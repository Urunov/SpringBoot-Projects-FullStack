package spring.file.exception;

import spring.file.service.FileStorageService;

/**
 * @Created 06 / 04 / 2020 - 2:52 PM
 * @project SpringFileUpDown
 * @Author Hamdamboy
 */
public class FileStorageException extends RuntimeException {
    //
    private static final long serialVerionUID = 1L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
