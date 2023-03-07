package DAOs;

import Models.Authtoken;

import java.io.StringBufferInputStream;
import java.util.List;

public class AuthtokenDAO{

    /**
     * Checks to see if we have the token in the database.
     * @param token The token we are checking is in database.
     * @return true if database has the token, false if not.
     */
    public boolean validAuthtoken(String token){
        return true;
    }

    /**
     * Returns an authtoken(s) which match the username we are looking for.
     * @param username the username we are searching for an authtoken for
     * @return the List of authtokens (likely just one) that matches the username
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
