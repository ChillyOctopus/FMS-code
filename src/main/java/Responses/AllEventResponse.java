package Responses;

import Models.Event;

/**
 * The response body for all Events.
 */
public class AllEventResponse extends BaseResponse{
    /**
     * array of Event objects to return
     */
    public Event[] data;

    public Event[] getData() {
        return data;
    }

    public void setData(Event[] data) {
        this.data = data;
    }

    /**
     * Constructor
     * @param data the data we are passing on
     * @param message the message we are sending
     * @param success the state of the request
     */
    public AllEventResponse(Event[] data, String message, boolean success){
        super(message,success);
        this.data = data;
    }
}
