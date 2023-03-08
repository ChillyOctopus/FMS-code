package Services;

import Requests.GetAllRequest;
import Responses.AllPersonResponse;

public class GetAllPersons {
    /**
     * classes copy of request
     */
    private GetAllRequest request;

    /**
     * Constructor
     * @param request the G.A.Req. object
     */
    public GetAllPersons(GetAllRequest request) {
        this.request = request;
    }

    /**
     * implements finding all persons
     * @return the All.Pers.Resp. object
     */
    public AllPersonResponse findAll(){
        AllPersonResponse response = null;
        return response;
    }

    /*
    1. Return ALL family members of the current user, determined by authtoken
     */
}
