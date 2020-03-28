package spring.database.exception;

/**
 * @Author: apple
 * @created on 28/03/2020
 * @Project is SpringPosgreslq
 */
public class ResourceNotFoundException extends Exception{
    //
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
