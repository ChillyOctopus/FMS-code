package DAOs;
import Models.Person;

import java.util.List;

public class PersonDAO {

    /**
     * Returns a single person from database based on ID
     * @param ID the ID of the person we want to summon from the database
     * @return a single person whose ID matches the parameter
     */
    public Person extractPerson(String ID){
        Person p = null;
        return p;
    }

    /**
     * Returns all people we have in the database
     * @param assocUserID the UserID we want to screen the people through
     * @return A list of people in the database
     */
    public List<Person> extractAllPersons(String assocUserID){
        List<Person> myList = null;
        return myList;
    }
}
