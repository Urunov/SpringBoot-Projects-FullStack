package com.urunov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
