package Services;

import DAOs.DataAccessException;
import Models.Person;
import Requests.GetAllRequest;
import Responses.AllPersonResponse;

import DAOs.AuthtokenDAO;
import DAOs.PersonDAO;

import java.util.List;

/**
 * Implements getting all persons
 */
public class GetAllPersons {

    /**
     * finds all persons
     * @param request the G.A.Req. object
     * @return the All.Pers.Resp. object
     */
    public AllPersonResponse findAll(GetAllRequest request){
        System.out.println("Inside implementation");
        try{
            AuthtokenDAO adoa = new AuthtokenDAO();
            System.out.println("Made adoa");
            String token = request.getAuthtoken();
            System.out.println("Token is:"+token);
            String user = adoa.findUsername(token);
            System.out.println("User is: "+user);
            List<Person> list;
            Person[] responseArray;
            if(user != null){
                System.out.println("Found user in \"find all\": "+user);
                PersonDAO pdao = new PersonDAO();
                list = pdao.findAll(user);
                responseArray = new Person[list.size()];
                for(int i = 0; i < list.size(); i++){
                    responseArray[i] = list.get(i);
                }
                return new AllPersonResponse(responseArray,null,true);
            } else {
                return new AllPersonResponse(null,"Error: Invalid Authtoken", false);
            }

        } catch(DataAccessException ex){
            System.out.println("Issue in DAOs.");
            return new AllPersonResponse(null,"Error:"+ex.getMessage(),false);
        }



    }

    /*
    1. Return ALL family members of the current user, determined by authtoken
     */
}
