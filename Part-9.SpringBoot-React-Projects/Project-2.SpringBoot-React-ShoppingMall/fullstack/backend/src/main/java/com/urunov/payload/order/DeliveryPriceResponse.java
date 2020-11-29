package com.urunov.payload.order;

import lombok.*;

import java.util.Map;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */


@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DeliveryPriceResponse {

    private String deliveryPrice;
    private String foundRightAddress;
    private Map<String, String > coordMap;

    public DeliveryPriceResponse(String deliveryPrice, String foundRightAddress, Map<String, String> coorMap)
    {
        this.deliveryPrice = deliveryPrice;
        this.foundRightAddress = foundRightAddress;
        this.coordMap = coorMap;
    }
    public Map<String, String> getCoordMap()
    {
        return coordMap;
    }


}
