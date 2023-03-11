package Services;

import DAOs.DataAccessException;
import Models.Person;
import Models.User;
import Models.Authtoken;
import Requests.FillRequest;
import Responses.FillResponse;
import DAOs.UserDAO;
import DAOs.PersonDAO;
import DAOs.AuthtokenDAO;

import java.util.List;

/**
 * Implements Fill
 */
public class Fill {

    /**
     * Fills generations in
     * @param request Fill.Req. object
     * @return a Fill.Resp. object
     */
    public FillResponse fill(FillRequest request){
       try {

           String name = request.getUsername();
           UserDAO udao = new UserDAO();
           User u = udao.findByUsername(name);

           PersonDAO pdao = new PersonDAO();
           List<Person> personList = pdao.findAll(u.getUsername());
           for(Person p : personList){
               pdao.delete(p.getPersonID());
           }

           /*
            TODO populate x generations, add to FillResponse Success
            generate(u.getUsername(),request.getGenerations);
            */

       }catch (DataAccessException ex){
           return new FillResponse("Error: "+ex.getMessage(),false);
       }

       return new FillResponse("Successfully added " + "_" + " persons and "+ "_" + " events to the database.", true);
    }

    /*
    1. Username must be registered.
    2. Delete data in database associated with username, if any.
    3. Populate with X generations for the username.
     */

}
