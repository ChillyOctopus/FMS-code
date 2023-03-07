package Services;

import Models.Event;

import java.util.List;

public class EventTree {

    /**
     * Gives a conglomerate of lifetime events of a given person
     * @param personID the person whose life events we return
     * @return a list of life events of a person specified through ID.
     */
    public List<Event> lifeEvents(String personID){
        List<Event> myList = null;
        return myList;
    }

    /**
     * The events in the lives of all of our ancestors
     * @param userID the user whose ancestors we are pulling from
     * @return a list of events from all the users ancestors lives.
     */
    public List<Event> ancestralEvents(String userID){
        List<Event> myList = null;
        return myList;
    }




}
