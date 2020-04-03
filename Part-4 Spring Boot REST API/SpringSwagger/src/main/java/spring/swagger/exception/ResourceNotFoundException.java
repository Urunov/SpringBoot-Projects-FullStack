package spring.swagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Created 03 / 04 / 2020 - 10:53 AM
 * @project SpringSwagger
 * @Author Hamdamboy
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends Exception{
    //
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
