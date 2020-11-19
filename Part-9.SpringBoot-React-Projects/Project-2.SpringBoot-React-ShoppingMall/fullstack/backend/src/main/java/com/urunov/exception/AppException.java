package com.urunov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException
{
    public AppException(String message){
        super(message);
    }
}
