package Services;

import DAOs.DataAccessException;
import Models.Event;
import Models.Person;
import Models.User;

import Requests.LoadRequest;
import Responses.ClearResponse;
import Responses.LoadResponse;

import DAOs.PersonDAO;
import DAOs.UserDAO;
import DAOs.EventDAO;

/**
 * Implements Load
 */
public class Load {
    /**
     * loads database
     * @param request the Load.Req. object
     * @return a Load.Resp. object
     */
    public LoadResponse load(LoadRequest request){
        boolean success = false;
        try {
            Clear wipe = new Clear();
            ClearResponse cr = wipe.clear();
            if(!cr.success){
                return new LoadResponse(cr.getMessage(), cr.isSuccess());
            }

            UserDAO udao = new UserDAO();
            for(User u : request.getUsers()){
                udao.insert(u);
            }

            PersonDAO pdao = new PersonDAO();
            for (Person p : request.getPersons()) {
                pdao.insert(p);
            }


            EventDAO edao = new EventDAO();
            for(Event e : request.getEvents()){
                edao.insert(e);
            }

        }catch (DataAccessException ex){
            return new LoadResponse(ex.getMessage(),false);
        }

        return new LoadResponse("Successfully added " +
                                request.getUsers().length + " users, " +
                                request.getPersons().length + " persons, and " +
                                request.getEvents().length + " events to the database.", true);
    }

    /*
    1. Clears all data from database (use clear)
    2. Load user, person, and events from req. body to database,
     */
}
