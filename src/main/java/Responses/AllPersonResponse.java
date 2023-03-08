package Responses;

import Models.Person;

/**
 * The response body for all Persons.
 */
public class AllPersonResponse extends BaseResponse {
    /**
     * array of Person objects to return
     */
    public Person[] data;

    /**
     * Constructor
     * @param data the data we are passing on
     * @param message the message we are sending
     * @param success the state of request
     */
    public AllPersonResponse(Person[] data, String message, boolean success) {
        super(message,success);
        this.data = data;
    }
}
