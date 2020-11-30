package com.urunov.service;

import com.google.gson.Gson;
import com.urunov.model.Good;
import com.urunov.model.OrderDetails;
import com.urunov.model.Orders;
import com.urunov.model.User;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.payload.good.GoodOrderDetailsResponse;
import com.urunov.payload.good.GoodQuantityResponse;
import com.urunov.repository.GoodsRepository;
import com.urunov.repository.OrderDetailsRepository;
import com.urunov.repository.OrderRepository;
import com.urunov.repository.UserRepository;
import com.urunov.security.UserPrincipal;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    OrderRepository orderRepository;

    private String getOrderDetailList(Orders order)
    {
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findAllByOrder(order);
        List<GoodOrderDetailsResponse> orderDetailsResponses = new ArrayList<>();

        for(OrderDetails orderDetails: orderDetailsList)
        {
            orderDetails.getGood().setImageUrl("data:image/jpg;base64," + Base64.encodeBase64String(orderDetails.getGood().getImage()));
            orderDetailsResponses.add(new GoodOrderDetailsResponse(orderDetails.getGood(), orderDetails.getQuantity(), orderDetails.getGood().getImageUrl(), orderDetails.getGood().getRetailer()));
        }
        return new Gson().toJson(orderDetailsResponses);
    }

    public String deleteFromUserBucket(UserPrincipal userPrincipal, Long goodId)
    {
        User user = userRepository.findById(userPrincipal.getId()).orElse(null);
        Orders order = orderRepository.findFirstByStatusAndUser(OrderStatus.NEW, user).orElse(null);
        Good good = goodsRepository.findById(goodId).orElse(null);

        if(good ==null)
            return null;
        if(user != null && order !=null)
        {
            OrderDetails orderDetails = orderDetailsRepository.findByGoodAndOrder(good, order).orElse(null);
            if(orderDetails != null) {
                order.getOrderDetailsList().remove(orderDetails);
                orderDetailsRepository.delete(orderDetails);
            }

        }

        return getOrderDetailList(order);
    }

    public String setGoodQuantity(UserPrincipal userPrincipal, GoodQuantityResponse goodQuantityResponse)
    {
        User user = userRepository.findById(userPrincipal.getId()).orElse(null);
        Orders order = orderRepository.findFirstByStatusAndUser(OrderStatus.NEW, user).orElse(null);
        Good good = goodsRepository.findById(goodQuantityResponse.getGoodId()).orElse(null);

        if(good == null)
            return null;

        if(user !=null && order !=null)
        {
            OrderDetails orderDetails = orderDetailsRepository.findByGoodAndOrder(good, order).orElse(null);
            if(orderDetails != null)
            {
                if(goodQuantityResponse.getEventType().equals("decrease"))
                {
                    if(orderDetails.getQuantity() != 1)
                    {
                        orderDetails.setQuantity(orderDetails.getQuantity() -1);
                        orderDetailsRepository.save(orderDetails);
                    }
                    else {
                        order.getOrderDetailsList().remove(orderDetails);
                        orderDetailsRepository.delete(orderDetails);
                    }
                }
                else {
                    orderDetails.setQuantity(orderDetails.getQuantity() +1);
                    orderDetailsRepository.save(orderDetails);
                }
            }
        }
        return getOrderDetailList(order);
    }

    public String getUserGood(UserPrincipal userPrincipal){

        User user = userRepository.findById(userPrincipal.getId()).orElse(null);
        if(user != null){
            Orders order = orderRepository.findFirstByStatusAndUser(OrderStatus.NEW, user).orElse(null);
            if(order != null){
                return getOrderDetailList(order);
            }
        }
        return null;
    }

    public void addToBucket(UserPrincipal userPrincipal, Long goodId){

        User user = userRepository.findById(userPrincipal.getId()).orElse(null);
        Good good = goodsRepository.findById(goodId).orElse(null);
        if(user != null && good !=null){
            good.setAddToBucket(true);
            OrderDetails orderDetails;
            Orders order = orderRepository.findFirstByStatusAndUser(OrderStatus.NEW, user).orElse(null);

            // TODO: спрашивать пользователя перед чисткой корзины

            List<OrderDetails> bucketGoods = orderDetailsRepository.findAllByOrder(order);
            if(!bucketGoods.isEmpty()){
                if(!bucketGoods.get(0).getGood().getRetailer().equals(good.getRetailer())){
                    for(OrderDetails bucketGood : bucketGoods){
                        orderDetailsRepository.delete(bucketGood);
                    }
                }
            }
            if(order == null){
                order = new Orders();
                order.setUser(user);
                order.setStatus(OrderStatus.NEW);
                orderRepository.save(order);
                orderDetails = new OrderDetails();
                orderDetails.setQuantity(1);
                orderDetails.setGood(good);
                orderDetails.setOrder(order);
            }
            else {
                orderDetails = orderDetailsRepository.findByGoodAndOrder(good, order).orElse(null);
                if(orderDetails !=null) {
                    orderDetails.setQuantity(orderDetails.getQuantity() + 1);
                } else {
                    orderDetails = new OrderDetails();
                    orderDetails.setQuantity(1);
                    orderDetails.setGood(good);
                    orderDetails.setOrder(order);
                }
            }
            orderDetailsRepository.save(orderDetails);
        }
    }
}
