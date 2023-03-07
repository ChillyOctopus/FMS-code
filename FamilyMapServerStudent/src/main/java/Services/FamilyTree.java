package Services;

import Models.Person;

import java.util.List;

public class FamilyTree {

    /**
     * returns a list of all a persons past relatives
     * @param personID the persons (user or regular) whose relatives we return
     * @return a list of the persons relatives based on ID
     */
    public List<Person> relatives(String personID){
        List<Person> myList = null;
        return myList;
    }

    /**
     * Function to find paternal line of person (user or regular)
     * @param personID the person in question
     * @return a list of Person objects, father->grandfather->great ect
     */
    public List<Person> paternalLine(String personID){
        List<Person> myList = null;
        return myList;
    }

    /**
     * Function to find maternal line of person (user or regular)
     * @param personID the person in question
     * @return a list of Person objects, mother->grandmother->great ect
     */
    public List<Person> maternalLine(String personID){
        List<Person> myList = null;
        return myList;
    }

}
