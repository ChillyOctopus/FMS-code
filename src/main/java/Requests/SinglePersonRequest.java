package Requests;

/**
 * Request body for a single Person.
 */
public class SinglePersonRequest {
    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

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
