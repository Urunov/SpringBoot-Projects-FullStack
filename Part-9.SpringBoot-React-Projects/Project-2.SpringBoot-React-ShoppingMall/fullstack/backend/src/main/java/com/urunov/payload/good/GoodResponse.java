package com.urunov.payload.good;

import com.urunov.model.Good;
import lombok.*;

import java.math.BigDecimal;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodResponse {

    private Long goodId;

    private String name;

    private BigDecimal price;

    private Long retailer;

    private Long retailerId;

    private String city;

    private byte[] image;

    private String ingredients;

    private Boolean isOutdated;

    private String internalCode;

    private Boolean isAddToBucket;


    public GoodResponse(Good good) {
        this.goodId = good.getId();
        this.name = good.getName();
        this.price = good.getCurrentPrice();
        this.retailer = good.getRetailer().getInternalCode();
        this.internalCode = good.getInternalCode();
        this.isAddToBucket = good.getAddToBucket();
        this.retailerId = good.getRetailer().getId();
        this.city = good.getRetailer().getCity();
    }
}
