package Responses;

/**
 * The response body for Clear.
 */
public class ClearResponse {
    /**
     * the message we will send
     */
    public String message;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param message the message we are passing on
     */
    public ClearResponse(String message) {
        this.message = message;
    }
}
