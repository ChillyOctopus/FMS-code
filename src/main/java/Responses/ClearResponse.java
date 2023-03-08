package Responses;

/**
 * The response body for Clear.
 */
public class ClearResponse extends BaseResponse{
    /**
     * Constructor
     * @param message the message we are passing on
     * @param success the state of the request
     */
    public ClearResponse(String message, boolean success) {
        super(message,success);
    }
}
