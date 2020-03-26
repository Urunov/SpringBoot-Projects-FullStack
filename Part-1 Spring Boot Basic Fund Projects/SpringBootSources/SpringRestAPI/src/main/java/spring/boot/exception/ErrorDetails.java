package spring.boot.exception;

import java.util.Date;

/**
 * @Created 26 / 03 / 2020 - 2:30 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */
public class ErrorDetails {
    //
    private Date timestamp;
    private String message;
    private String details;


    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage(){
        return message;
    }

    public String getDetails(){
        return details;
    }
}
