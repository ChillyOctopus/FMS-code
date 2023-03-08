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

    public void setFatherID(String fatherID) {
        this.fatherID = fatherID;
    }

    public void setMotherID(String motherID) {
        this.motherID = motherID;
    }

    public void setSpouseID(String spouseID) {
        this.spouseID = spouseID;
    }

    /**
     * Constructor
     * @param associatedUsername the username who is a descendant of person
     * @param personID the persons id
     * @param firstName their first name
     * @param lastName their last name
     * @param gender their gender
     */
    public SinglePersonResponse(String associatedUsername, String personID, String firstName, String lastName, String gender,String message, boolean success) {
        super(message,success);
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
