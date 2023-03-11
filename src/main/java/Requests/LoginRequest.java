package Requests;

/**
 * Request body for Login.
 */
public class LoginRequest {
    /**
     * the username
     */
    private String username;
    /**
     * the password
     */
    private String password;

    /**
     * Constructor
     * @param username the username to login
     * @param password the password to use
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
