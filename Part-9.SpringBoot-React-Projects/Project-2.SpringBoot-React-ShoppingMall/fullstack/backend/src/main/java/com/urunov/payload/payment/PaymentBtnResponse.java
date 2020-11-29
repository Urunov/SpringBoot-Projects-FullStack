package com.urunov.payload.payment;

import lombok.*;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBtnResponse {

    public String sign;

    public String shopToken;

    public String regPayNum;

    public String payUrl;

    public String code;

    public String userMessage;
}
