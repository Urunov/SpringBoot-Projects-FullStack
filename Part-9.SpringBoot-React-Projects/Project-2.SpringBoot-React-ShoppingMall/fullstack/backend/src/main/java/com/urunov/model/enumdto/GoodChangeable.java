package com.urunov.model.enumdto;

import lombok.ToString;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@ToString
public enum GoodChangeable {


    CHANGEABLE("Можно обменять Possible change"), UNCHANGEABLE("Нельзя обменять Impossible to change");


    private String title;

    public String getTitle(){
        return title;
    }
    GoodChangeable(String title){
        this.title = title;
    }
}
