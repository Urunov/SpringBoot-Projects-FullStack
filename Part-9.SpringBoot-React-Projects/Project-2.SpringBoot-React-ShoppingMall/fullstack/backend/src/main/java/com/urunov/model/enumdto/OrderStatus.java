package com.urunov.model.enumdto;

import lombok.ToString;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@ToString
public enum OrderStatus {

    awaitingPayment("Ожидает оплаты (Awaiting Payment )"),
    NEW("Новый New"),
    inProgress("В обработке Processing"),
    paid("Оплачен Paid"),
    canceled("Отменен Canceled"),
    courierSearch("Поиск курьера CourierSearch"),
    courierFound("Курьер найден Courier Found" ),
    deliveryInProgress("Выполняется доставка DeliveryProcess"),
    awaitingConfirmation("Ожидает подтверждения Conformation awaiting"),
    delivered("Доставлен Delivered");

    OrderStatus(String title){
        this.title = title;
    }

    private String title;

    public String getTitle(){
        return title;
    }



}
