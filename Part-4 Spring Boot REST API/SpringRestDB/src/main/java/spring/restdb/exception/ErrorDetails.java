package spring.restdb.exception;

import java.util.Date;

/**
 * @Created 01 / 04 / 2020 - 5:18 PM
 * @project SpringRestDB
 * @Author Hamdamboy
 */
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ErrorDetails(Date timestamp, String message, String details){
        super();

        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
    }


}
