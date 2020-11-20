package com.urunov.payload.good;

import com.urunov.model.Good;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodResponseForRetailer {

    private Long id;

    private String internalCode;

    private String name;

    private BigDecimal currentPrice;

    private String imageUrl;

    private Boolean isAddToBucket;

    private Long retailer;

    private Boolean isOutdated;

    private Instant createdAt;


    public GoodResponseForRetailer(Good good) {

        this.id = good.getId();
        this.internalCode = good.getInternalCode();
        this.name = good.getName();
        this.currentPrice = good.getCurrentPrice();
        this.imageUrl = good.getImageUrl();
        this.isAddToBucket = good.getIsAddToBucket();
        this.retailer = good.getRetailer().getId();
        this.isOutdated = good.getIsOutdated();
        this.createdAt = good.getCreatedAt();

    }
}
