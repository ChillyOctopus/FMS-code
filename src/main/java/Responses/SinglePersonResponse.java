package Responses;

/**
 * The response body for a single Person.
 */
public class SinglePersonResponse {
    /**
     * the associated Username to return
     */
    public String associatedUsername;
    /**
     * the personID to return
     */
    public String personID;
    /**
     * the first name to return
     */
    public String firstName;
    /**
     * the last name to return
     */
    public String lastName;
    /**
     * the gender to return
     */
    public String gender;
    /**
     * the father ID to return
     */
    public String fatherID;
    /**
     * the mother ID to return
     */
    public String motherID;
    /**
     * the spouse ID to return
     */
    public String spouseID;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param associatedUsername the username who is a descendent of person
     * @param personID the persons id
     * @param firstName their first name
     * @param lastName their last name
     * @param gender their gender
     * @param fatherID their fathers ID (optional)
     * @param motherID their mothers ID (optional)
     * @param spouseID their spouses ID (optional)
     */
    public SinglePersonResponse(String associatedUsername, String personID, String firstName, String lastName, String gender, String fatherID, String motherID, String spouseID) {
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.fatherID = fatherID;
        this.motherID = motherID;
        this.spouseID = spouseID;
    }
}
