package Responses;

/**
 * The response body for Login.
 */
public class LoginResponse {
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
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param authtoken the authtoken we are returning
     * @param username the username we are returning
     * @param personID the personID we are returning
     */
    public LoginResponse(String authtoken, String username, String personID) {
        this.authtoken = authtoken;
        this.username = username;
        this.personID = personID;
    }
}
