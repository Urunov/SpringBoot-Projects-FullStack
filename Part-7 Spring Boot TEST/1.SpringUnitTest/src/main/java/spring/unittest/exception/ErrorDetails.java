package spring.unittest.exception;

import java.util.Date;

/**
 * @Created 27 / 04 / 2020 - 4:46 PM
 * @project 1.SpringUnitTest
 * @Author Hamdamboy
 */
public class ErrorDetails  {

    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details){
        super();
        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
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
