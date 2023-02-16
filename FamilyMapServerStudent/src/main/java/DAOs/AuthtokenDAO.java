package DAOs;

import Models.Authtoken;

import java.util.List;

public class AuthtokenDAO {

    /**
     * Returns an authtoken who matches the username we are looking for.
     * @param username the username we are searching for an authtoken for
     * @return the authtoken that matches the username
     */
    public List<Authtoken> extractAuthtoken(String username){
        List<Authtoken> myList = null;
        return myList;
    }

    /**
     * get all the Authtokens in the database.
     * @return A list of the authtokens we have.
     */
    public List<Authtoken> extractAllAuthtokens(){
        List<Authtoken> myTotalList = null;
        return myTotalList;
    }
}
