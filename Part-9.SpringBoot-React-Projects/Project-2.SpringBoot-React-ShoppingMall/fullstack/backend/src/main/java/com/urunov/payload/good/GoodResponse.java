package com.urunov.payload.good;

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


}
