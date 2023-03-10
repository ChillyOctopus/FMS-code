package Services;

import Requests.LoginRequest;
import Responses.LoginResponse;

import java.util.Random;

/**
 * Implements Login
 */
public class Login {
    /**
     * Logs the user in
     * @param request the Log.Req. object
     * @return a Log.Resp. object
     */
    public LoginResponse login(LoginRequest request){
        LoginResponse response = null;
        return response;
    }

    /**
     * The charset we pull from to make the authtokens.
     */
    private static final String TOKENCHARS = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    /**
     * Generating our id's & authtokens
     * @return the authtoken
     */
    private String generateUniqueString(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        int count = random.nextInt(9);
        count += 12;

        for(int i = 0; i < count; i++){
            result.append(TOKENCHARS.charAt(random.nextInt(TOKENCHARS.length())));
        }

        return result.toString();
    }

    /*
    1. Log user in
    2. Return authtoken
     */
}
