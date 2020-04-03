package spring.swagger.exception;

import java.util.Date;

/**
 * @Created 03 / 04 / 2020 - 10:53 AM
 * @project SpringSwagger
 * @Author Hamdamboy
 */


public class ErrorDetails{

    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public String getMessage(){
        return message;
    }

    public String getDetails(){
        return details;
    }
}

