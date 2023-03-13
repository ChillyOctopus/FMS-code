package Services;

import DAOs.AuthtokenDAO;
import DAOs.DataAccessException;
import DAOs.EventDAO;

import Models.Event;

import Requests.GetAllRequest;
import Responses.AllEventResponse;

import java.util.List;

/**
 * Implements getting all events
 */
public class GetAllEvents {
    /**
     * finds all events
     * @param request the G.A.Req. object
     * @return the All.Eve.Resp. object
     */
    public AllEventResponse findAll(GetAllRequest request){
        try{
            AuthtokenDAO adoa = new AuthtokenDAO();
            System.out.println("Made adoa");
            String token = request.getAuthtoken();
            System.out.println("Token is:"+token);
            String user = adoa.findUsername(token);
            System.out.println("User is: "+user);
            List<Event> list;
            Event[] responseArray;
            if(user != null){
                System.out.println("Found user in \"find all\": "+user);
                EventDAO edao = new EventDAO();
                list = edao.findAll(user);
                responseArray = new Event[list.size()];
                for(int i = 0; i < list.size(); i++){
                    responseArray[i] = list.get(i);
                }
                return new AllEventResponse(responseArray,null,true);
            } else {
                return new AllEventResponse(null,"Error: Invalid Authtoken", false);
            }

        } catch(DataAccessException ex){
            System.out.println("Issue in DAOs.");
            return new AllEventResponse(null,"Error:"+ex.getMessage(),false);
        }
    }

    /*
    1. Return ALL events of the current user, determined by authtoken
     */
}
