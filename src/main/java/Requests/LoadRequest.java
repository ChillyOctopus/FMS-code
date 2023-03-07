package Requests;

import Models.Event;
import Models.Person;
import Models.User;

/**
 * Request body for Load.
 */
public class LoadRequest {
    /**
     * the array of User object
     */
    private User [] users;
    /**
     * the array of Person objects
     */
    private Person[] persons;
    /**
     * the array of Event objects
     */
    private Event[] events;

    /**
     * Constructor
     * @param users the user object array to load
     * @param persons the person object array to load
     * @param events the event object array to load
     */
    public LoadRequest(User[] users, Person[] persons, Event[] events) {
        this.users = users;
        this.persons = persons;
        this.events = events;
    }
}
