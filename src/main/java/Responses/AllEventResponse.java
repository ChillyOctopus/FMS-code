package Responses;

import Models.Event;

/**
 * The response body for all Events.
 */
public class AllEventResponse {
    /**
     * array of Event objects to return
     */
    public Event[] Eventdata;
    /**
     * the boolean state of whether our service worked or not
     */
    public boolean success = true;

    /**
     * Constructor
     * @param eventdata the array of Events we are sending
     */
    public AllEventResponse(Event[] eventdata) {
        Eventdata = eventdata;
    }
}
