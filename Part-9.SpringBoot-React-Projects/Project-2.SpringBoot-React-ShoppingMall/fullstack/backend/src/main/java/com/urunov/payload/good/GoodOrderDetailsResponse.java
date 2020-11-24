package com.urunov.payload.good;

import com.urunov.model.Good;
import com.urunov.model.retailer.Retailer;
import lombok.*;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodOrderDetailsResponse extends GoodResponse{

    private Integer quantity;

    private String imageUrl;

    private String retailerName;

    private String retailerCity;

    public GoodOrderDetailsResponse(Good good, Integer quantity, String imageUrl, Retailer retailerDto)
    {
        super(good);
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.retailerCity = retailerDto.getCity();
        this.retailerName = retailerDto.getName();
    }
}
