package Responses;

/**
 * The response body for a single Event.
 */
public class SingleEventResponse extends BaseResponse{
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
    public Float latitude;
    /**
     * the longitude to return
     */
    public Float longitude;
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

    public String getAssociatedUsername() {
        return associatedUsername;
    }

    public void setAssociatedUsername(String associatedUsername) {
        this.associatedUsername = associatedUsername;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * the year to return
     */
    public Integer year;

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
    public SingleEventResponse(String associatedUsername, String personID, float latitude, float longitude, String country, String city, String eventType, int year, String message, boolean success) {
        super(message,success);
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public SingleEventResponse(String message, boolean success){
        super(message,success);
    }

}
