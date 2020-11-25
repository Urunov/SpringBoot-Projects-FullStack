package com.urunov.payload.payment;

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
public class PaymentStatusResponse {
    /**
     * статус платежа
     */
    private String state;

    /**
     * сумма платежа в копейках
     */
    private String totalAmount;

    /**
     * время создания платежа (Время должно быть в формате: yyyy-mm-dd hh:mm:ss)
     */
    private String createdDate;

    /**
     * уникальный код провайдера услуг
     */
    private String providerServCode;

    /**
     * название провайдера услуг
     */
    private String providerName;

    /**
     * код ошибки, используется для локализации проблемы.(
     */
    private String errorCode;


}
