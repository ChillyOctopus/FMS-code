package Responses;

/**
 * The response body for all Errors.
 */
public class ErrorResponse {
    /**
     * the message we will send
     */
    public String message;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = false;

    /**
     * Constructor
     * @param message the message we are passing along
     */
    public ErrorResponse(String message) {
        this.message = message;
    }
}
