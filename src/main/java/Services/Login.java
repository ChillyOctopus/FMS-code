package Services;

import DAOs.DataAccessException;
import Models.Authtoken;
import Models.User;
import Requests.LoginRequest;
import Responses.LoginResponse;
import DAOs.UserDAO;
import DAOs.AuthtokenDAO;

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
    public LoginResponse login(LoginRequest request) {
        try {

            UserDAO udao = new UserDAO();
            String name = request.getUsername();
            System.out.println("Searching database for: "+name);
            User u = udao.findByUsername(name);
            System.out.println("Found user with username: " + u.getUsername());
            String token = generateUniqueString();

            Authtoken auther = new Authtoken(token,u.getUsername());
            AuthtokenDAO adao = new AuthtokenDAO();
            System.out.println("Created authtoken object, passing into adoa.");
            adao.insert(auther);

            return new LoginResponse(token,u.getUsername(),u.getPersonID(),null,true);

        }catch(DataAccessException ex){
            return new LoginResponse(ex.getMessage(),false);
        }
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
