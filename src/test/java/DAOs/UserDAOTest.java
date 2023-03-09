package DAOs;

import Models.User;
import org.junit.jupiter.api.*;

import javax.xml.crypto.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {
    private User happyUser;
    private User sadUser;
    private UserDAO uDao;

    @BeforeEach
    public void setup() throws DataAccessException{
        happyUser = new User("Jacob123","nullPointerException","stevenson@MAIL.ORG","Jacob",
                "Stevenson", "m", "g6978^&*(");
        sadUser = new User("Jared321","SegFault000x0000","Nobodyknows@where.com","Jared",
                "Blinky", "m", "adh0t7iu");
        uDao = new UserDAO();
        uDao.clear();
    }

    @AfterEach
    public void teardown() throws DataAccessException{
        uDao.DB.closeConnection(false);
    }

    @Test
    public void insertPass() throws DataAccessException{
        uDao.insert(happyUser);
        User u = uDao.find(happyUser.getPersonID());
        assertNotNull(u);
        assertEquals(happyUser, u);

        uDao.insert(sadUser);
        u = uDao.find((sadUser.getPersonID()));
        assertNotNull(u);
        assertEquals(sadUser, u);
    }

    @Test
    public void insertFail() throws DataAccessException{
        uDao.insert(happyUser);
        assertThrows(DataAccessException.class, ()-> uDao.insert(happyUser));
        sadUser.setEmail(null);
        assertThrows(DataAccessException.class, ()-> uDao.insert(sadUser));
    }

    @Test
    public void findPass() throws DataAccessException{
        uDao.insert(happyUser);
        User u = uDao.find(happyUser.getPersonID());
        assertEquals(happyUser, u);
    }

    @Test
    public void findFail() throws DataAccessException{
        assertThrows(DataAccessException.class, ()->uDao.find(happyUser.getPersonID()));
        uDao.insert(sadUser);
        assertThrows(DataAccessException.class, ()->uDao.find(happyUser.getPersonID()));
        assertThrows(DataAccessException.class, ()->uDao.find("randomString"));
        sadUser.setPersonID(null);
        assertThrows(DataAccessException.class, ()->uDao.find(sadUser.getPersonID()));
        assertThrows(DataAccessException.class, ()->uDao.find(null));
    }

    @Test
    public void clear() throws DataAccessException{
        uDao.insert(sadUser);
        uDao.insert(happyUser);
        uDao.clear();
        LinkedList<User> l = uDao.findAll();
        assertEquals(0,l.size());
    }

}
