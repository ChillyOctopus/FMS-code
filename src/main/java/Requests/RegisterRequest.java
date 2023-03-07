package Requests;

/**
 * Request body for Register.
 */
public class RegisterRequest {
    /**
     * the username
     */
    private String username;
    /**
     * the password
     */
    private String password;
    /**
     * the firstName
     */
    private String firstName;
    /**
     * the lastName
     */
    private String lastName;
    /**
     * the gender
     */
    private String gender;

    /**
     * Constructor
     * @param username the username
     * @param password the password
     * @param firstName the first name
     * @param lastName the last name
     * @param gender the gender
     */
    public RegisterRequest(String username, String password, String firstName, String lastName, String gender) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
