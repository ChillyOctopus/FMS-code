package DAOs;
import Models.Event;

import java.util.List;

public class EventDAO {

    /**
     * finds an event in the database that has matching eventID
     * @param EventID the ID of the event we are looking for
     * @return the single event whose ID matches the parameter
     */
    public Event extractEvent(String EventID){
        Event e = null;
        return e;
    }

    /**
     * returns all the events in the database that correspond with a user
     * @param assocUserID the userID we are screening events through
     * @return a list of events that match the UserID
     */
    public List<Event> extractAllEvents(String assocUserID){
        List<Event> myList = null;
        return myList;
    }
}
