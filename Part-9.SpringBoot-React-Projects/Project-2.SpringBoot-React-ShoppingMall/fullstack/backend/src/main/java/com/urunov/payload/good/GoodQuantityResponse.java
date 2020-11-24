package com.urunov.payload.good;

import lombok.*;

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
public class GoodQuantityResponse {

    private Long goodId;

    private String eventType;

}
