package Requests;

/**
 * Request body for a single Person.
 */
public class SinglePersonRequest {
    /**
     * the authtoken
     */
    private String authtoken;

    /**
     * the person ID
     */
    private String personID;

    /**
     * Constructor
     * @param authtoken the authtoken we are given
     * @param personID the person we are searching for
     */
    public SinglePersonRequest(String authtoken, String personID) {
        this.authtoken = authtoken;
        this.personID = personID;
    }
}
