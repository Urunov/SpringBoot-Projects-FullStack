package com.urunov.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
public class UserIdentityAvailability {

    private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }


}
