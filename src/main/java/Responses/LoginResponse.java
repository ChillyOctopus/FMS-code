package Responses;

/**
 * The response body for Login.
 */
public class LoginResponse extends BaseResponse{
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
     * @param message the message we are passing on
     * @param success the state of the request
     * @param authtoken the authtoken we are returning
     * @param username the username we are returning
     * @param personID the personID we are returning
     */
    public LoginResponse(String authtoken, String username, String personID, String message, boolean success) {
        super(message,success);
        this.authtoken = authtoken;
        this.username = username;
        this.personID = personID;
    }

    public LoginResponse(String message, boolean success){
        super(message,success);
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
}
