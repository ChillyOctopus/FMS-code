package Responses;

/**
 * The response body for Register.
 */
public class RegisterResponse extends BaseResponse{
    /**
     * the authtoken to return
     */
    public String authtoken;
    /**
     * the username to return
     */
    public String username;
    /**
     * the personID to return
     */
    public String personID;

    /**
     * Constructor
     * @param success the state of the request
     * @param message message we are passing on
     * @param authtoken the authtoken we are returning
     * @param username the username we are returning
     * @param personID the personID we are returning
     */
    public RegisterResponse(String authtoken, String username, String personID, String message, boolean success) {
        super(message,success);
        this.authtoken = authtoken;
        this.username = username;
        this.personID = personID;
    }

    public RegisterResponse(String message, boolean success) {
        super(message,success);
    }
}
