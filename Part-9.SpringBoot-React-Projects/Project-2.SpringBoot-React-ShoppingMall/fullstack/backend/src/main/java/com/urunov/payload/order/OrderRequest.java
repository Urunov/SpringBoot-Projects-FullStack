package com.urunov.payload.order;

import com.urunov.payload.good.GoodOrderDetailsResponse;
import lombok.*;

import java.util.List;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String email;

    private String additionalPhone;

    private String address;

    private String name;

    private String comment;

    private Float deliveryPrice;

    private List<GoodOrderDetailsResponse> goods;

}
