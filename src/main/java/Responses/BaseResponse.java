package Responses;

/**
 * The basic response body.
 */
public class BaseResponse {
    /**
     * the message we will send
     */
    public String message;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success;

    /**
     * Constructor
     * @param message the message we are passing on
     * @param success state of the request
     */
    public BaseResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
