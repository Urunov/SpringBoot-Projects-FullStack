package com.urunov.model.enumdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@ToString
@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    awaitingPayment("Ожидает оплаты / Waiting payment"),
    NEW("Новый / New"),
    inProgress("В обработке / inprocess"),
    paid("Оплачен / Paid"),
    canceled("Отменен / Canceled"),
    courierSearch("Поиск курьера/ courierSearch"),
    courierFound("Курьер найден / CourierFound"),
    deliveryInProgress("Выполняется доставка / DeliveryInProcess"),
    awaitingConfirmation("Ожидает подтверждения / awaitingConfirmation"),
    delivered("Доставлен/Delivered");

    OrderStatus(String title) {
        this.title = title;
    }
    private String title;

}
