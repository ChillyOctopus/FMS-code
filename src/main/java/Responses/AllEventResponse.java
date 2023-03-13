package Responses;

import Models.Event;

/**
 * The response body for all Events.
 */
public class AllEventResponse extends BaseResponse{
    /**
     * array of Event objects to return
     */
    public Event[] eventdata;

    public Event[] getEventdata() {
        return eventdata;
    }

    public void setEventdata(Event[] eventdata) {
        this.eventdata = eventdata;
    }

    /**
     * Constructor
     * @param eventdata the data we are passing on
     * @param message the message we are sending
     * @param success the state of the request
     */
    public AllEventResponse(Event[] eventdata, String message, boolean success){
        super(message,success);
        this.eventdata = eventdata;
    }
}
