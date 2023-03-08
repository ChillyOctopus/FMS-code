package Responses;

import Models.Person;

/**
 * The response body for all Persons.
 */
public class AllPersonResponse {
    /**
     * array of Person objects to return
     */
    public Person[] data;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param data the array we are returning.
     */
    public AllPersonResponse(Person[] data) {
        this.data = data;
    }
}
