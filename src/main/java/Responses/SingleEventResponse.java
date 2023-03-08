package Responses;

/**
 * The response body for a single Event.
 */
public class SingleEventResponse {
    /**
     * the associated Username to return
     */
    public String associatedUsername;
    /**
     * the personID to return
     */
    public String personID;
    /**
     * the latitude to return
     */
    public float latitude;
    /**
     * the longitude to return
     */
    public float longitude;
    /**
     * the country to return
     */
    public String country;
    /**
     * the city to return
     */
    public String city;
    /**
     * the event type to return
     */
    public String eventType;
    /**
     * the year to return
     */
    public int year;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param associatedUsername the username this event belongs to
     * @param personID the person this event happened to
     * @param latitude the latitude
     * @param longitude the longitude
     * @param country the country
     * @param city the city
     * @param eventType the type of event
     * @param year the year it happened
     */
    public SingleEventResponse(String associatedUsername, String personID, float latitude, float longitude, String country, String city, String eventType, int year) {
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }
}
