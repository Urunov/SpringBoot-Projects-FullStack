package com.urunov.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * User: hamdamboy
 * Project: Ecommerce
 * Github: @urunov
 */
public enum Role implements GrantedAuthority {

        USER,

        ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
