package Services;

import Models.Person;
import Requests.SinglePersonRequest;
import Responses.SinglePersonResponse;
import Responses.ErrorResponse;

/**
 * Implements finding a single person
 */
public class SinglePerson {
    /**
     * classes copy of request
     */
    SinglePersonRequest request;

    /**
     * Constructor
     * @param request Sing.Pers.Req. object
     */
    public SinglePerson(SinglePersonRequest request) {
        this.request = request;
    }

    /**
     * finds a single person
     * @return a Sing.Pers.Resp. object
     */
    public SinglePersonResponse find(){
        SinglePersonResponse response = null;
        return response;
    }

    /*
    1. Return the single person object with the specified ID related to current user, determined by authtoken
     */
}
