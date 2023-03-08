package Services;

import Requests.LoadRequest;
import Responses.LoadResponse;
import Responses.ErrorResponse;

/**
 * Implements Load
 */
public class Load {
    /**
     * classes copy of request
     */
    private LoadRequest request;

    /**
     * Constructor
     * @param request the Load.Req. object
     */
    public Load(LoadRequest request) {
        this.request = request;
    }

    /**
     * loads database
     * @return a Load.Resp. object
     */
    public LoadResponse load(){
       LoadResponse response = null;
       return response;
    }

    /*
    1. Clears all data from database (use clear)
    2. Load user, person, and events from req. body to database,
     */
}
