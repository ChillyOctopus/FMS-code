package Services;

import Requests.FillRequest;
import Responses.FillResponse;
import Responses.ErrorResponse;

/**
 * Implements Fill
 */
public class Fill {

    /**
     * classes copy of request
     */
    private FillRequest request;

    /**
     * Constructor
     * @param request Fill.Req. object
     */
    public Fill(FillRequest request){
        this.request = request;
    }

    /**
     * Fills generations in
     * @return a Fill.Resp. object
     */
    public FillResponse fill(){
        FillResponse response = null;
        return response;
    }

    /*
    1. Username must be registered.
    2. Delete data in database associated with username, if any.
    3. Populate with X generations for the username.
     */

}
