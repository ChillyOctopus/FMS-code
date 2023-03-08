package Responses;

/**
 * The response body for Load.
 */
public class LoadResponse extends BaseResponse{
    /**
     * Constructor
     * @param message the message we are passing on
     * @param success the state of the request
     */
    public LoadResponse(String message, boolean success) {
        super(message,success);
    }
}
