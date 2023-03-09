package Services;

import DAOs.DataAccessException;
import Requests.RegisterRequest;
import Responses.RegisterResponse;

import Models.User;
import DAOs.UserDAO;

import java.util.Random;

/**
 * Implements register
 */
public class Register {
     /**
     * Registers the user.
     * @param request the Reg.Req. object
     * @return a Reg.Resp. object.
     */
    public RegisterResponse register(RegisterRequest request) {

        String Userid = generateUniqueString();
        User u = new User(
                request.getUsername(),
                request.getPassword(),
                request.getEmail(),
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                Userid);

        UserDAO dao = new UserDAO();


        try {
            dao.insert(u);
        }catch(DataAccessException ex){
            RegisterResponse response = new RegisterResponse(ex.getMessage(), false);
            return response;
        }

        String authtoken = generateUniqueString();
        RegisterResponse response = new RegisterResponse(authtoken, u.getUsername(), u.getPersonID(), null, true);
        return response;
    }

    /**
     * The charset we pull from to make the authtokens.
     */
    private static final String TOKENCHARS = "0123456789`~!@#$%^&><()-_=+|}]{[AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

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
