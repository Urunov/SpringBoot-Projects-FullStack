package com.urunov.payload.order;

import com.urunov.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse
{
    private Long id;

    //private List<GoodOrderDetailsResponse> goodList;

    private Long retailer;

    private String retailerName;

    private String address;

    private Float deliveryPrice;

    private String status;

    private String createdAt;

    private BigDecimal totalSum = new BigDecimal(0);

    private String paymentNumber;

    private String carMark;

    private String carModel;

    private String carColor;

    private String carNumber;

    private String nameDriver;

    private String phoneDriver;

    public OrderResponse(Orders orders)
    {
        this.id = orders.getId();
        this.address = orders.getAddress();
        this.deliveryPrice = orders.getDeliveryPrice() != null ? orders.getDeliveryPrice(): 0F;
        this.status = orders.getStatus().getTitle();
    }



}
