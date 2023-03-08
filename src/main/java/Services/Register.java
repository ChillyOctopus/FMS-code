package Services;

import Models.Person;
import Requests.RegisterRequest;
import Responses.RegisterResponse;
import Responses.ErrorResponse;

import java.util.Random;

/**
 * Implements register
 */
public class Register {

    /**
     * classes copy of request object
     */
    private RegisterRequest request;

    /**
     * Constructor
     * @param request the Reg.Req. object
     */
    public Register(RegisterRequest request) {
        this.request = request;
    }

    /**
     * Registers the user.
     * @return a Reg.Resp. object.
     */
    public RegisterResponse register() {
        RegisterResponse response = null;
        return response;
    }

    /**
     * The charset we pull from to make the authtokens.
     */
    private static final String TOKENCHARS = "01234567890`~!@#$%^&><AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    /**
     * Generating our authtokens
     * @return the authtoken
     */
    private String generateAuthtoken(){
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        int count = random.nextInt(9);
        count += 8;

        for(int i = 0; i < count; i++){
            result.append(TOKENCHARS.charAt(random.nextInt(TOKENCHARS.length())));
        }

        String token = result.toString();
        return token;
    }

    /*
    1. Need to create a new user in the DB
    2. Generate 4 gens of ancestors (use fill)
    3. Log the user in (use login)
    4. Return authtoken (use login)
     */

}
