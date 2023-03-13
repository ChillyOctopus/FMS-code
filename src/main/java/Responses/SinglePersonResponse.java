package Responses;

/**
 * The response body for a single Person.
 */
public class SinglePersonResponse extends BaseResponse{
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
     * Constructor
     * @param message the message
     * @param success state of request
     * @param associatedUsername the user whom this person "belongs to"
     * @param personID this persons ID
     * @param firstName this persons first name
     * @param lastName this persons last name
     * @param gender this persons gender
     * @param fatherID this persons fathers ID
     * @param motherID this persons mothers ID
     * @param spouseID this persons spouses ID
     */
    public SinglePersonResponse(String message, boolean success, String associatedUsername, String personID, String firstName, String lastName, String gender, String fatherID, String motherID, String spouseID) {
        super(message, success);
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
