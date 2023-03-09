package DAOs;

import Models.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sqlite.core.DB;

import static org.junit.jupiter.api.Assertions.*;

//We will use this to test that our insert method is working and failing in the right ways
public class PersonDAOTest {
    private Person bestPerson;
    private PersonDAO pDao;

    @BeforeEach
    public void setUp() throws DataAccessException {
        // and a new event with random data
        bestPerson = new Person("h89t7a", "Jacob", "John",
                "Doe", "m", null,null,null);

        pDao = new PersonDAO();
        //Let's clear the database as well so any lingering data doesn't affect our tests
        pDao.clear();
    }

    @AfterEach
    public void tearDown() {
        // Here we close the connection to the database file, so it can be opened again later.
        // We will set commit to false because we do not want to save the changes to the database
        // between test cases.
        pDao.DB.closeConnection(false);
    }

    @Test
    public void insertPass() throws DataAccessException {
        // Start by inserting a person into the database.
        pDao.insert(bestPerson);
        // Let's use a find method to get the person that we just put in back out.
        Person compareTest = pDao.find(bestPerson.getPersonID());
        // First lets see if our find method found anything at all. If it did then we know that we got
        // something back from our database.
        assertNotNull(compareTest);
        // Now lets make sure that what we put in is the same as what we got out. If this
        // passes then we know that our insert did put something in, and that it didn't change the
        // data in any way.
        // This assertion works by calling the equals method in the Person class.
        assertEquals(bestPerson, compareTest);
    }

    @Test
    public void insertFail() throws DataAccessException {
        // Let's do this test again, but this time lets try to make it fail.
        // If we call the method the first time the event will be inserted successfully.
        pDao.insert(bestPerson);

        // However, our sql table is set up so that the column "eventID" must be unique, so trying to insert
        // the same event again will cause the insert method to throw an exception, and we can verify this
        // behavior by using the assertThrows assertion as shown below.

        // Note: This call uses a lambda function. A lambda function runs the code that comes after
        // the "()->", and the assertThrows assertion expects the code that ran to throw an
        // instance of the class in the first parameter, which in this case is a DataAccessException.
        assertThrows(DataAccessException.class, () -> pDao.insert(bestPerson));
    }
}