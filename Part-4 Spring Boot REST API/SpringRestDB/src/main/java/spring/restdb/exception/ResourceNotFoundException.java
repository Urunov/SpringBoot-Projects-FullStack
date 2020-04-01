package spring.restdb.exception;

/**
 * @Created 01 / 04 / 2020 - 5:28 PM
 * @project SpringRestDB
 * @Author Hamdamboy
 */
public class ResourceNotFoundException extends  Exception{
    //
    private static final long serailVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
