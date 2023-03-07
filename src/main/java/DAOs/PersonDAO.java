package DAOs;
import Models.Person;

import java.util.List;
/**
 * In-between for Person models and database.
 */

public class PersonDAO {

    /**
     * Inserting a Person object into database.
     * @param person the object we are inserting.
     * @throws DataAccessException
     */
    public void insert(Person person) throws DataAccessException{
        return;
    }

    /**
     * Returns a single person from database based on ID
     * @param ID the ID of the person we want to summon from the database
     * @return a single person whose ID matches the parameter
     * @throws DataAccessException
     */
    public Person find(String ID) throws DataAccessException {
        Person p = null;
        return p;
    }

    /**
     * Returns all people we have in the database
     * @param assocUserID the UserID we want to screen the people through
     * @return A list of people in the database
     * @throws DataAccessException
     */
    public List<Person> findAll(String assocUserID) throws DataAccessException{
        List<Person> myList = null;
        return myList;
    }

    /**
     * Clearing all the Person data from database.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
        return;
    }
}
