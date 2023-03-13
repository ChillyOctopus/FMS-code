package Services;

import DAOs.AuthtokenDAO;
import DAOs.DataAccessException;
import DAOs.PersonDAO;
import Models.Person;
import Requests.SinglePersonRequest;
import Responses.SinglePersonResponse;

import java.util.Objects;

/**
 * Implements finding a single person
 */
public class SinglePerson {
    /**
     * finds a single person
     * @param request Sing.Pers.Req. object
     * @return a Sing.Pers.Resp. object
     */
    public SinglePersonResponse find(SinglePersonRequest request){
        try{
            AuthtokenDAO adoa = new AuthtokenDAO();
            String user = adoa.findUsername(request.getAuthtoken());
            if(user != null){
                PersonDAO pdao = new PersonDAO();
                Person p = pdao.find(request.getPersonID());
                if(Objects.equals(p.getAssociatedUsername(), user)){
                    return new SinglePersonResponse(null,true,
                            p.getAssociatedUsername(),
                            p.getPersonID(),
                            p.getFirstName(),
                            p.getLastName(),
                            p.getGender(),
                            p.getFatherID(),
                            p.getMotherID(),
                            p.getSpouseID());

                } else {
                        return new SinglePersonResponse("Error: The person who has this ID does not belong to the user.", false,null,null,null,null,null,null,null,null);
                }

            } else {
                return new SinglePersonResponse("Error: Invalid Authtoken", false,null,null,null,null,null,null,null,null);

            }

        } catch(DataAccessException ex){
            return new SinglePersonResponse(ex.getMessage(), false,null,null,null,null,null,null,null,null);

        }
    }

    /*
    1. Return the single person object with the specified ID related to current user, determined by authtoken
     */
}
