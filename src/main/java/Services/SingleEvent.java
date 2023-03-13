package Services;

import DAOs.AuthtokenDAO;
import DAOs.DataAccessException;
import DAOs.EventDAO;
import Models.Event;
import Models.Person;
import Requests.SingleEventRequest;
import Responses.SingleEventResponse;

import java.util.Objects;

/**
 * Implements finding a single event
 */
public class SingleEvent {
    /**
     * finds a single event
     * @param request Sing.Eve.Req. object
     * @return a Sing.Eve.Resp. object
     */
    public SingleEventResponse find(SingleEventRequest request){
        try{
            AuthtokenDAO adoa = new AuthtokenDAO();
            String user = adoa.findUsername(request.getAuthtoken());
            if(user != null){
                EventDAO edao = new EventDAO();
                Event e = edao.find(request.getEventID());
                if(Objects.equals(e.getAssociatedUsername(), user)){
                    return new SingleEventResponse(e.getAssociatedUsername(),
                            e.getPersonID(),
                            e.getLatitude(),
                            e.getLongitude(),
                            e.getCountry(),
                            e.getCity(),
                            e.getEventType(),
                            e.getYear(),
                            e.getEventID(),
                            true);

                } else {
                    return new SingleEventResponse("Error: The event that has this ID does not belong to the user.", false);
                }

            } else {
                return new SingleEventResponse("Error: Invalid Authtoken", false);

            }

        } catch(DataAccessException ex){
            return new SingleEventResponse(ex.getMessage(), false);

        }
    }

    /*
    1. Return the single event object with the specified ID related to current user, determined by authtoken
     */
}
