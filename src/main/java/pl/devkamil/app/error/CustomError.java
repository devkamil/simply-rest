package pl.devkamil.app.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Class with error information: 'code' - code of error; 'message' - message of error; 'timestamp' - date of error
 */
public class CustomError {

    @JsonProperty
    private Integer code;
    @JsonProperty
    private String message;
    @JsonProperty
    private Long timestamp;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public CustomError(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date().getTime();
    }
}
