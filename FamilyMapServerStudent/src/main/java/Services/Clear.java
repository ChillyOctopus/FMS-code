package Services;

public class Clear {
    /**
     * clears all tables from the database. Probably don't call it.
     */
    public void clearAll(){

    }

    /**
     * clears all data associated with that userID
     * @param userID the ID we look through and clear
     */
    public void deleteUser(String userID){

    }

    /**
     * clears all people "related" to a specified user
     * @param userID the user we clear all relatives from
     */
    public void clearRelatives(String userID){

    }

    /**
     * clears all events related to a person (user or regular)
     * @param personID the ID we search for and clear events from
     */
    public void clearEvents(String personID){

    }

    /**
     * Clears all authtoken tables
     */
    public void clearAuths(){

    }
}
