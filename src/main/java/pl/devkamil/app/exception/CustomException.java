package pl.devkamil.app.exception;

import org.springframework.http.HttpStatus;

/**
 * Class which extends 'Exception' class; it stores a params: 'httpStatus' and 'message'
 */
public class CustomException extends Exception {

    private HttpStatus httpStatus;
    private String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
