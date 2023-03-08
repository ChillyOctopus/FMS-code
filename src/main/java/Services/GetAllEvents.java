package Services;

import Requests.GetAllRequest;
import Responses.AllEventResponse;

public class GetAllEvents {
    /**
     * classes copy of request
     */
    private GetAllRequest request;

    /**
     * Constructor
     * @param request the G.A.Req. object
     */
    public GetAllEvents(GetAllRequest request) {
        this.request = request;
    }

    /**
     * implements finding all events
     * @return the All.Eve.Resp. object
     */
    public AllEventResponse findAll(){
        AllEventResponse response = null;
        return response;
    }

    /*
    1. Return ALL events of the current user, determined by authtoken
     */
}
