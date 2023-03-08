package Services;

import Models.Event;
import Requests.SingleEventRequest;
import Responses.SingleEventResponse;
import Responses.ErrorResponse;

/**
 * Implements finding a single event
 */
public class SingleEvent {
    /**
     * classes copy of request
     */
    SingleEventRequest request;

    /**
     * Constructor
     * @param request Sing.Eve.Req. object
     */
    public SingleEvent(SingleEventRequest request) {
        this.request = request;
    }

    /**
     * finds a single event
     * @return a Sing.Eve.Resp. object
     */
    public SingleEventResponse find(){
        SingleEventResponse response = null;
        return response;
    }

    /*
    1. Return the single event object with the specified ID related to current user, determined by authtoken
     */
}
