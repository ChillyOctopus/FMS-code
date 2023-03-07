package Responses;

import Models.Event;
import Models.Person;

public class LoginResponse {
    /**
     * the authtoken to return
     */
    public String authtoken;
    /**
     * the username to return
     */
    public String username;
    /**
     * the personID to return
     */
    public String personID;
    /**
     * the associated Username to return
     */
    public String associatedUsername;
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
     * array of Person objects to return
     */
    public Person[] data;
    /**
     * the event ID to return
     */
    public String eventID;
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
     * array of Event objects to return
     */
    public Event[] Eventdata;
    /**
     * the message we will send
     */
    public String message;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success;
}
