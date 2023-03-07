package Req_Res;

import Models.Event;
import Models.Person;
import Models.User;

/**
 * Generic request body, able to set parameters to null or not null and forward objects as JSON to services
 */
public class RequestBody {
    /**
     * the username
     */
    public String username;
    /**
     * the password
     */
    public String password;
    /**
     * the email
     */
    public String email;
    /**
     * the firstName
     */
    public String firstName;
    /**
     * the lastName
     */
    public String lastName;
    /**
     * the gender
     */
    public String gender;
    /**
     * the array of User objects (load only)
     */
    public User [] users;
    /**
     * the array of Person objects (load only)
     */
    public Person[] persons;
    /**
     * the array of Event objects (load only)
     */
    public Event[] events;
}
