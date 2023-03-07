package Requests;

/**
 * Request body for a single Event.
 */
public class SingleEventRequest {
    /**
     * the authtoken
     */
    private String authtoken;
    /**
     * the ID that matches event we are searching for
     */
    private String eventID;

    /**
     * Constructor
     * @param authtoken the authtoken in question
     * @param eventID the ID we are looking for
     */
    public SingleEventRequest(String authtoken, String eventID) {
        this.authtoken = authtoken;
        this.eventID = eventID;
    }
}
