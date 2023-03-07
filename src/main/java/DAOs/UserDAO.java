package DAOs;
import Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * In-between for User models and database.
 */
public class UserDAO{

    /**
     * Inserting a User object into the database.
     * @param user the object we are inserting.
     * @throws DataAccessException
     */
    public void insert(User user) throws DataAccessException {
        return;
    }

    /**
     * Returns a single user based on ID.
     * @param ID the ID we are searching for.
     * @return the User object from the database.
     */
    public User extractUser(String ID){
        UserDAO dao = new UserDAO();
        /*
        ResultSet rs = dao.getRecord("user", "personID", ID);
        if(rs!=null){
            try{
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getString("personID"));

            } catch(SQLException ex){
                System.err.println("Something went wrong returning user..." + ex.getMessage());
            }
        }
         */
        return null;
    }

    /**
     * Returns all the users in the Database.
     * @return A list of User objects.
     */
    public List<User> extractAllUsers(){
        List<User> myList = null;
        return myList;

    }
}
