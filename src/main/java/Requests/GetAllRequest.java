package Requests;

/**
 * Request body for "Get-All".
 */
public class GetAllRequest {
    /**
     * the authtoken
     */
    private String authtoken;

    /**
     * Constructor
     * @param authtoken the authtoken in question
     */
    public GetAllRequest(String authtoken) {
        this.authtoken = authtoken;
    }
}
