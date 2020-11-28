package com.urunov.service.taxiMaster;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.urunov.model.Orders;
import com.urunov.model.gson.bitMasterApi.driverInfo.DriverInfo;
import com.urunov.model.gson.bitMasterApi.driverInfo.Phone;
import com.urunov.model.gson.bitMasterApi.orderState.OrderState;
import com.urunov.model.retailer.Retailer;
import com.urunov.model.taxi.TaxiProperties;
import com.urunov.payload.order.DeliveryPriceResponse;
import com.urunov.repository.OrderRepository;
import com.urunov.service.taxiMaster.utils.AddressUtils;
import org.apache.http.client.utils.DateUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class TaxiOrderProcess {

    @Autowired
    TMApi api;

    @Autowired
    AddressUtils addressUtils;

    @Autowired
    DateUtils dateUtils;

    @Autowired
    OrderRepository orderRepository;


    private final Logger LOG = LoggerFactory.getLogger(TaxiProperties.class);

    JSONParser parser = new JSONParser();

    public DeliveryPriceResponse findAddressCoords(String city, String queryAddress, TaxiProperties taxiProperties) throws Exception
    {
        Address address = null;
        JSONParser parser = new JSONParser();
        String source_lon = "0";
        String source_lat = "0";
        String addrRequest = "get_streets=true&get_points=true&get_houses=true"
                + "&search_in_tm=true&search_in_yandex=true&search_in_google=true&search_in_2gis=true&search_in_tmgeoservice=true"
                + "&city=" + city + "&address=" + queryAddress;
        LOG.info("Finding address in TM: " + addrRequest);
        String addrResult = api.call("get_addresses_like2", addrRequest, "GET", "", taxiProperties);
        JSONObject jsonObject = (JSONObject)parser.parse(addrResult);
        if(!jsonObject.get("code").equals(0L))
        {
            LOG.error("Error finding address: [" + jsonObject.get("code") + "]. Reason: [" + jsonObject.get("descr") + "]");
        }
        else
        {
            JSONObject data = (JSONObject)jsonObject.get("data");
            JSONArray addresses = (JSONArray)data.get("addresses");
            address = AddressParser.analyzeAddresses(addressUtils.cleanAddress(queryAddress, city), addresses);
            if(address != null)
            {
                source_lat = address.lat.toString();
                source_lon = address.lon.toString();
            }
            else
            {
                source_lat = "0.0";
                source_lon = "0.0";
            }
        }
        Map<String, String> coordMap = new HashMap<>();
        coordMap.put(source_lat, source_lon);
        return new DeliveryPriceResponse(null, address != null? address.street + ", " + address.house: null, coordMap);
    }

    public DeliveryPriceResponse getDeliveryPrice(String city, String clientAddress, String shopAddress, TaxiProperties taxiProperties) throws Exception
    {
        //TODO: Сделать свой обработчик, не бросать ошибку в лог
        if(findAddressCoords(city, clientAddress, taxiProperties).getCoordMap().keySet().toArray()[0].equals("0") || findAddressCoords(city, clientAddress, taxiProperties).getCoordMap().values().toArray()[0].equals("0"))
            throw new Exception("Адрес не найден");
        String clientLat = "";
        String clientLon = "";
        String shopLat = "";
        String shopLon = "";
        DeliveryPriceResponse deliveryPriceResponse = findAddressCoords(city, clientAddress, taxiProperties);
        for(Map.Entry<String, String> entry : deliveryPriceResponse.getCoordMap().entrySet())
        {
            clientLat = entry.getKey();
            clientLon = entry.getValue();
        }
        for(Map.Entry<String, String> entry : findAddressCoords(city, shopAddress, taxiProperties).getCoordMap().entrySet())
        {
            shopLat = entry.getKey();
            shopLon = entry.getValue();
        }
        String request = "{ \n\"tariff_id\": " + 0 + ",\n" +
                "\"source_time\": \"" + dateUtils.getRussianDate(new Date()) + "\",\n" +
                "\"is_prior\": " + true + ",\n" +
                "\"client_id\": " + 0 + ",\n" +
                "\"discount_id\": " + 0 + ",\n" +
                "\"disc_card_id\": " + 0 + ",\n" +
                "\"source_zone_id\": " + 0 + ",\n" +
                "\"source_lat\": " + shopLat + ",\n" +
                "\"source_lon\": " + shopLon + ",\n" +
                "\"dest_lat\": " + clientLat + ",\n" +
                "\"dest_lon\": " + clientLon + ",\n" +
                "\"is_prize\": " + false + "\n}";
        LOG.info("Sending request to TMServer Common API: calc_order_cost2 [" + request + "]");
        String result = api.call("calc_order_cost2", request, "POST", "application/json", taxiProperties);
        LOG.info("Parsing answer from TMServer Common API..." + (result));
        JSONObject jsonObject = (JSONObject)parser.parse(result);
        JSONObject data = (JSONObject)jsonObject.get("data");
        return new DeliveryPriceResponse(((JSONObject)jsonObject.get("data")).get("sum").toString(), deliveryPriceResponse.getFoundRightAddress(), null);
    }

    public void createTaxiOrder(Orders order, Retailer retailer) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String sourceTime = sdf.format(Date.from(order.getCreatedAt()));
        String passenger = order.getUser().getName();
        //	String order_params = "";
        // — Атрибуты заказа (надо будет присвоить атрибут "Доставка", у каждой службы такси таких атрибутов будет один или несколько; для тестового заказа используй 24)
        //	order_params = "\"order_params\" : [" + "{\"Доставка\": \"24\"}" + "],\n";
        //		String crewGroupId = "\"crew_group_id\": " + 2 + ",\n";
        Map<String, String> shippingAddress = findAddressCoords(retailer.getCity(), retailer.getShippingAddress(), retailer.getTaxiPropertiesList().get(0)).getCoordMap();
        Map<String, String> destinationAddress = findAddressCoords(retailer.getCity(), order.getAddress(), retailer.getTaxiPropertiesList().get(0)).getCoordMap();
        String request = "{ \n\"phone\": \"" + order.getUser().getPhone() + "\",\n" +
                "\"client_id\":" + 79 + ",\n" +
                "\"addresses\":[\n" +
                "{\"address\":\"" + retailer.getShippingAddress() + "\",\"lat\":" + shippingAddress.keySet().toArray()[0] + "," + "\"lon\": " + shippingAddress.values().toArray()[0] + ",\"zone_id\":" + 0 + ",\"parking_id\":" + 0 + "},\n" +
                "{\"address\":\"" + order.getAddress() + "\",\"lat\":" + destinationAddress.keySet().toArray()[0] + "," + "\"lon\": " + destinationAddress.values().toArray()[0] + ",\"zone_id\":" + 0 + ",\"parking_id\":" + 0 + "}],\n" +
                "\"source_time\": \"" + sourceTime + "\",\n" +
                "\"passenger\": \"" + passenger + "\",\n" +
                "\"email\": \"" + order.getEmail() + "\",\n" +
                //		crewGroupId +
                //		order_params +
                "\"server_time_offset\": " + 0 + ",\n" +
                "\"comment\": \"" + (order.getComment() == null? "": order.getComment()) + "\" \n}";
        LOG.info("Sending request to TMServer Common API: create_order2 [" + request + "]");
        String result = api.call("create_order2", request, "POST", "application/json", retailer.getTaxiPropertiesList().get(0));
        LOG.info("Parsing answer from TMServer Common API..." + result);
        JSONObject jsonObject = (JSONObject)parser.parse(result);
        String orderId = "";
        if(!jsonObject.get("code").equals(0L))
        {
            LOG.info("Error creating order at TMServer: [" + jsonObject.get("code") + "]");
        }
        else
        {
            if(((JSONObject)jsonObject.get("data")).get("order_id") != null)
            {
                orderId = ((JSONObject)jsonObject.get("data")).get("order_id").toString();
                LOG.info("Order created: " + orderId);
                order.setTaxiOrderId(Long.valueOf(orderId));
                orderRepository.save(order);
            }
        }
    }

    public Map<String, String> getTaxiOrderStatus(Long orderId, Retailer retailer) throws ParseException
    {
        Gson gson = new Gson();
        Map<String, String> resultMap = new HashMap<>();
        OrderState orderState = null;
        DriverInfo driverInfo = null;
        String request = "order_id=" + orderId;
        String result = api.call("get_order_state", request, "GET", "", retailer.getTaxiPropertiesList().get(0));
        try {
            orderState = gson.fromJson(result, OrderState.class);
        } catch (JsonSyntaxException jse) {
            jse.printStackTrace();
        }

        if(orderState != null && orderState.getDescr().equals("OK"))
        {
            Integer driverId = orderState.getData().getDriverId();
            if (driverId != null) {
                String requestParam = "driver_id=" + driverId +"&need_photo=false";
                String resultInfoDriver = api.call("get_driver_info", requestParam, "GET", "", retailer.getTaxiPropertiesList().get(0));
                if (resultInfoDriver != null) {
                    try {
                        driverInfo = gson.fromJson(resultInfoDriver, DriverInfo.class);
                    } catch (JsonSyntaxException jse) {
                        jse.printStackTrace();
                    }
                    if (driverInfo != null && driverInfo.getDescr().equals("OK")){
                        resultMap.put("name", driverInfo.getData().getName());
                        List<Phone> phoneList = driverInfo.getData().getPhones().stream().filter(Phone::getUseForCall).collect(Collectors.toList());
                        if (phoneList.size() > 0)
                            resultMap.put("phones", phoneList.get(0).getPhone());
                        else
                            resultMap.put("phones", "телефон не указан");
                    } else
                    {
                        resultMap.put("name", "Фио не указано");
                        resultMap.put("phones", "телефон не указан");
                    }
                }
            }
            resultMap.put("get_order_state", orderState.getData().getStateKind());
            resultMap.put("car_mark", orderState.getData().getCarMark());
            resultMap.put("car_model", orderState.getData().getCarModel());
            resultMap.put("car_color", orderState.getData().getCarColor());
            resultMap.put("car_number", orderState.getData().getCarNumber());
            return resultMap;
        }
        else
        {
            return null;
        }
    }



}
