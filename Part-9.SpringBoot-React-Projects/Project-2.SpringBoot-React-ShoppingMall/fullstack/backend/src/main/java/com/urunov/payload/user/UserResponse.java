package com.urunov.payload.user;

import com.urunov.model.User;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
public class UserResponse {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String email;

    private String city;


    public UserResponse(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.city = user.getCity();
    }

    public UserResponse(Long id, String username, String name, String phone, String email)
    {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.email = email;
    }


}
