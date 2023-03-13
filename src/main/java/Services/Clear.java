package Services;

import DAOs.*;
import Models.Person;
import Responses.ClearResponse;

/**
 * Implements clear
 */
public class Clear {
    /**
     * clears everything
     * @return the cle.Resp. object
     */
    public ClearResponse clear(){
        try {
            UserDAO udao = new UserDAO();
            udao.clear();
            PersonDAO pdao = new PersonDAO();
            pdao.clear();
            AuthtokenDAO adao = new AuthtokenDAO();
            adao.clear();
            EventDAO edao = new EventDAO();
            edao.clear();
        }catch(DataAccessException ex){
            return new ClearResponse("Error: "+ex.getMessage(), false);
        }
        return new ClearResponse("Clear succeeded", true);
    }


    /*
    1. Delete ALL data from database.
     */
}
