package com.urunov.payload;

import lombok.*;

import java.util.Date;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse {

    private Boolean success;
    private String message;
    private Date date;
    private Object object;


    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
