package spring.file.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Created 06 / 04 / 2020 - 2:53 PM
 * @project SpringFileUpDown
 * @Author Hamdamboy
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = 1L;

    public FileNotFoundException(String message){
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
