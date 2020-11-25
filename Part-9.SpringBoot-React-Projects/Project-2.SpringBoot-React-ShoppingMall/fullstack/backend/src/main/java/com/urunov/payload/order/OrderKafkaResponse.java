package com.urunov.payload.order;

import com.urunov.model.OrderDetails;
import com.urunov.model.Orders;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.payload.good.GoodOrderDetailsResponse;
import com.urunov.payload.user.UserResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderKafkaResponse {

    private Long id;

    private String email;

    private String additionsPhone;

    private String address;

    private String name;

    private String comment;

    private UserResponse user;

    private OrderStatus orderStatus;

    private List<GoodOrderDetailsResponse> goodList;

    private Float deliveryPrice;

    private BigDecimal totalSum = new BigDecimal(0);

    public OrderKafkaResponse(Orders orders)
    {
        this.id = orders.getId();
        this.email = orders.getEmail();
        this.additionsPhone = orders.getAdditionalPhone();
        this.address = orders.getAddress();
        this.name = orders.getName();
        this.comment = orders.getComment();
        this.user = new UserResponse(orders.getUser());
        this.orderStatus = orders.getStatus();
        this.deliveryPrice = orders.getDeliveryPrice();
        if(orders.getOrderDetailsList() != null)
        {
            List<GoodOrderDetailsResponse> orderDetailsResponses = new ArrayList<>();
            for(OrderDetails goodOrderDetailsResponse: orders.getOrderDetailsList()){
                orderDetailsResponses.add(new GoodOrderDetailsResponse(goodOrderDetailsResponse.getGood(), goodOrderDetailsResponse.getQuantity(),
                        goodOrderDetailsResponse.getGood().getImageUrl(), goodOrderDetailsResponse.getGood().getRetailer()));
            }

            this.goodList = orderDetailsResponses;
        }

        for(OrderDetails orderDetails: orders.getOrderDetailsList())
        {
            this.totalSum = this.totalSum.add(orderDetails.getGood().getCurrentPrice() !=null ?
                    orderDetails.getGood().getCurrentPrice().multiply(new BigDecimal(orderDetails.getQuantity())): new BigDecimal(0));
        }
    }



}
