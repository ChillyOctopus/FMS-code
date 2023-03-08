package Responses;

/**
 * The response body for Fill.
 */
public class FillResponse extends BaseResponse{
    /**
     * Constructor
     * @param message the message we are passing on
     * @param success the state of the request
     */
    public FillResponse(String message, boolean success) {
        super(message,success);
    }
}
