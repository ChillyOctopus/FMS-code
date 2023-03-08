package Services;

import Requests.LoginRequest;
import Responses.LoginResponse;
import Responses.ErrorResponse;

/**
 * Implements Login
 */
public class Login {

    /**
     * classes copy of request
     */
    private LoginRequest request;

    /**
     * Constructor
     * @param request the Log.Req. object
     */
    public Login(LoginRequest request) {
        this.request = request;
    }

    /**
     * Logs the user in
     * @return a Log.Resp. object
     */
    public LoginResponse login(){
        LoginResponse response = null;
        return response;
    }

    /*
    1. Log user in
    2. Return authtoken
     */
}
