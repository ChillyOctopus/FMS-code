package Responses;

/**
 * The response body for Load.
 */
public class LoadResponse {
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
    public LoadResponse(String message) {
        this.message = message;
    }
}
