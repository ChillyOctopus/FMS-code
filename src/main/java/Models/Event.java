package Models;

import java.util.Objects;

public class Event {
    /**
     * The ID we can reference the event with.
     */
    private String eventID;
    /**
     * The username this event "belongs" to.
     */
    private String associatedUsername;
    /**
     * The ID of the person this event "belongs" to.
     */
    private String personID;
    /**
     * The latitude of the event.
     */
    private Float latitude;
    /**
     * The longitude of the event.
     */
    private Float longitude;
    /**
     * The country location of the event.
     */
    private String country;
    /**
     * The city location of the event.
     */
    private String city;
    /**
     * The type of event.
     */
    private String eventType;
    /**
     * The year the event occurred.
     */
    private Integer year;
    /**
     * Constructor
     * @param eventID the eventID
     * @param username the username associated to the person associated to this event
     * @param personID the associated personID
     * @param latitude the latitude
     * @param longitude the longitude
     * @param country the country
     * @param city the city
     * @param eventType the type
     * @param year the year
     */
    public Event(String eventID, String username, String personID, Float latitude, Float longitude,
                 String country, String city, String eventType, Integer year) {
        this.eventID = eventID;
        this.associatedUsername = username;
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventID, event.eventID) && Objects.equals(associatedUsername, event.associatedUsername) && Objects.equals(personID, event.personID) && Objects.equals(latitude, event.latitude) && Objects.equals(longitude, event.longitude) && Objects.equals(country, event.country) && Objects.equals(city, event.city) && Objects.equals(eventType, event.eventType) && Objects.equals(year, event.year);
    }
}