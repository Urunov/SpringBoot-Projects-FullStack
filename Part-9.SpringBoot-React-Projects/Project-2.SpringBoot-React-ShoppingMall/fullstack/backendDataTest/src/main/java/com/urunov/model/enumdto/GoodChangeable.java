package com.urunov.model.enumdto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */



@RequiredArgsConstructor
@ToString
public enum  GoodChangeable {

    CHANGEABLE("Можно обменять / changeable"), UNCHANGEABLE("Нельзя обменять / unchangeable");

    GoodChangeable(String title){
        this.title = title;
    }
    private String title;
}
