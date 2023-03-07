package DAOs;
import Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * DAO for user, building new users from database.
 */
public class UserDAO extends abstractDAO {

    /**
     * Returns a single user
     * @param ID given their ID
     * @return the User object from the database
     */
    public User extractUser(String ID){
        UserDAO dao = new UserDAO();
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
        return null;

    }

    /**
     * Returns all the users in the Database
     * @return A list of User objects
     */
    public List<User> extractAllUsers(){
        List<User> myList = null;
        return myList;

    }
}
