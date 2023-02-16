package Models;

public class Event {
    /**
     * generated ID that has been assigned to Event
     */
    private String eventID;
    /**
     * the user whose 'relatives' this event has 'happened' to
     */
    private String associatedUsername;
    /**
     * the Person this event has 'happened' to
     */
    private String personID;
    /**
     * latitudinal location of said event
     */
    private float latitude;
    /**
     * longitudinal location of said event
     */
    private float longitude;
    /**
     * country location of said event
     */
    private String country;
    /**
     * city location of said event
     */
    private String city;
    /**
     * Type of event
     */
    private String eventType;
    /**
     * year said event happened
     */
    private int year;

    /**
     * Constructor
     * @param eventID generated ID that has been assigned to Event
     * @param associatedUsername the user whose 'relatives' this event has 'happened' to
     * @param personID the Person this event has 'happened' to
     * @param latitude latitudinal location of said event
     * @param longitude longitudinal location of said event
     * @param country country location of said event
     * @param city city location of said event
     * @param eventType Type of event
     * @param year year said event happened
     */

    public Event(String eventID, String associatedUsername, String personID, float latitude, float longitude, String country, String city, String eventType, int year) {
        this.eventID = eventID;
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }
























    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

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
}
