package spring.unittest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Created 27 / 04 / 2020 - 4:44 PM
 * @project 1.SpringUnitTest
 * @Author Hamdamboy
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }

}
