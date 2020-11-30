package com.urunov.schedule;

import com.urunov.kafkaService.Producer;
import com.urunov.model.Orders;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.payload.payment.PaymentStatusResponse;
import com.urunov.repository.OrderRepository;
import com.urunov.service.order.payment.PaymentService;
import com.urunov.service.taxiMaster.TaxiOrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Component
public class OrderStatusRequester {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Producer producer;

    @Autowired
    private TaxiOrderProcess taxiOrderProcess;

    @Scheduled(fixedDelayString = "${ckassa.requeststatus.pauseTimeSec}000")
    public void requestOrdersStatus() throws Exception{

        List<Orders> ordersList = orderRepository.findAllByStatusAndPaymentNumberIsNotNull(OrderStatus.awaitingPayment);
        for(Orders orders: ordersList){
            PaymentStatusResponse paymentStatusResponse = paymentService.getPaymentStatus(orders.getPaymentNumber());
            if (paymentStatusResponse.getState().equals("payed") || paymentStatusResponse.getState().equals("processed") || paymentStatusResponse.getState().equals("holded"))
            {
                orders.setStatus(OrderStatus.paid);
                orderRepository.save(orders);
                producer.sendOrderRequest(orders);
                taxiOrderProcess.createTaxiOrder(orders, orders.getOrderDetailsList().get(0).getGood().getRetailer());
            }
        }
    }

    @Scheduled(fixedDelayString = "${tm.requestTaxiOrderStatus.pauseTimeSec}000")
    public void requestTaxiOrderStatus() throws Exception{

        List<Orders> ordersList = orderRepository.findAllByStatusAndPaymentNumberIsNotNull(OrderStatus.awaitingPayment);
        for(Orders orders: ordersList){

            OrderStatus prevOrderStatus = orders.getStatus();
            Map<String, String> mapResult = taxiOrderProcess.getTaxiOrderStatus(orders.getTaxiOrderId(), orders.getOrderDetailsList().get(0).getGood().getRetailer());

            if(mapResult !=null){
                switch (mapResult.get("get_order_state")) {
                    case "new_order":
                        ordersSave(orders, OrderStatus.courierSearch, mapResult);
                        break;
                    case "driver_assigned":
                        ordersSave(orders, OrderStatus.courierFound, mapResult);
                        break;
                    case "car_at_place":
                        ordersSave(orders, OrderStatus.courierFound, mapResult);
                        break;
                    case "client_inside":
                        ordersSave(orders, OrderStatus.deliveryInProgress, mapResult);
                        break;
                    case "finished":
                        ordersSave(orders, OrderStatus.awaitingConfirmation, mapResult);
                        break;
                }
            }

            if(!prevOrderStatus.equals(orders.getStatus())){
                producer.sendOrderRequest(orders);
            }
        }
    }

    private void ordersSave(Orders orders, OrderStatus status, Map<String, String> mapResult)
    {
        orders.setCarColor(mapResult.get("car_color"));
        orders.setCarMark(mapResult.get("car_mark"));
        orders.setCarModel(mapResult.get("car_model"));
        orders.setCarNumber(mapResult.get("car_number"));
        orders.setStatus(status);
        orders.setNameDriver(mapResult.get("name"));
        orders.setPhoneDriver(mapResult.get("phones"));
        orderRepository.save(orders);

    }
}
