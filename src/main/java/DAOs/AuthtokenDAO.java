package DAOs;

import Models.Authtoken;

import java.io.StringBufferInputStream;
import java.util.List;
/**
 * In-between for Authtoken models and database.
 */
public class AuthtokenDAO{

    /**
     * Inserting a token object into the database.
     * @param token the token we are inserting.
     * @throws DataAccessException
     */
    public void insert(Authtoken token) throws DataAccessException{
        return;
    }

    /**
     * Checks to see if we have the token in the database.
     * @param token The token we are checking is in database.
     * @return true if database has the token, false if not.
     */
    public boolean verify(String token){
        return true;
    }

    /**
     * Returns a list of authtokens (likely just one) which match the username we are looking for.
     * @param username the username we are searching for an authtoken for
     * @return the list of authtokens (likely just one) that matches the username
     */
    public List<Authtoken> find(String username){
        List<Authtoken> myList = null;
        return myList;
    }

    /**
     * get all the Authtokens in the database.
     * @return A list of the authtokens we have.
     */
    public List<Authtoken> findAll(){
        List<Authtoken> myTotalList = null;
        return myTotalList;
    }

    /**
     * Clearing all the Authtoken data from database.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
        return;
    }
}
