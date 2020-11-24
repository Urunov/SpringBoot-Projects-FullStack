package com.urunov.payload.payment;

import lombok.*;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class PaymentResponse {

    /**
     * подпись to Sign
     */
    private String sign;


    /**
     * код провайдера
     */
    private String serviceCode;

    /**
     * токен пользователя
     */
    private String userToken;

        /**
        * сумма платежа в копейках (сумма которая идет на счет пользователю)
		 */
    private Integer amount;

    /**
     * комиссия платежа в копейках (если нет комиссии - передается 0)
     */
    private String comission;

    /**
     * идентификатор карты (для рекуррентного платежа), см. пункт Получение списка карт
     */
    private String cardToken;

    /**
     * тип клиента
     */
    private String clientType;

    /**
     * Токен при оплате через Google Pay. Более подробно в разделе Google Pay
     */
    private String gPayToken;

    /**
     * Номер телефона пользователя(для СМС платежа), с которого будет произведена оплата
     */
    private String userPhone;

    /**
     * номер телефона с кодом, но без + (например, 79999999999)
     */
    private String login;

    /**
     * e-mail для отправки фискального чека
     */
    private String email;

    /**
     * Имя пользователя
     */
    private String name;

    /**
     * Фамилия пользователя
     */
    private String surName;

    /**
     * Отчество пользователя
     */
    private String middleName;

    /**
     * Описание Параметра
     */
    private String fiscalType;

    /**
     * способ оплаты
     */
    private String payType;

    /**
     * Время истечения срока жизни заказа в секундах. Подробнее
     */
    private String orderBestBefore;

    /**
     * массив реквизитов
     */
    private List<CKassaRequestProperties> properties;

    private String regPayNum;

    /**
     * идентификатор организации
     */
    private String shopToken;

    /**
     * секретный ключ магазина
     */
    private String shopSecKey;

}
