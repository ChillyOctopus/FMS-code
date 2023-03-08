package DAOs;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 * In-between for User models and database.
 */
public class UserDAO extends BaseDAO{

    public final String insertSQL = "INSERT INTO User VALUES ? ? ? ? ? ? ?";
    public final String findAllSQL = "SELECT * FROM User";
    public final String deleteSQL = "DELETE FROM User WHERE username = ?";
    public final String clearSQL = "DELETE FROM User";

    /**
     * Inserting a User object into the database.
     * @param user the object we are inserting.
     * @throws DataAccessException
     */
    public void insert(User user) throws DataAccessException {
        //First check if anything the user has is null, needs to be a full object
        if(user.getUsername() == null ||
           user.getPassword() == null ||
           user.getEmail() == null ||
           user.getFirstName() == null ||
           user.getLastName() == null ||
           user.getGender() == null ||
           user.getPersonID() == null){

            System.out.println("1 or more elements of user object are null - will not insert into database.\n");
            return;
        }
        try (PreparedStatement prepStmt = DB.getConnection().prepareStatement(insertSQL))
        {
            prepStmt.setString(1,user.getUsername());
            prepStmt.setString(2,user.getPassword());
            prepStmt.setString(3,user.getEmail());
            prepStmt.setString(4,user.getFirstName());
            prepStmt.setString(5,user.getLastName());
            prepStmt.setString(6,user.getGender());
            prepStmt.setString(7,user.getPersonID());

            prepStmt.executeQuery();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Failed to insert User.\n");
        }
    }

    /**
     * Returns a single user based on ID.
     * @param ID the ID we are searching for.
     * @return the User object from the database.
     */
    public User findByID(String ID){
        ResultSet rs = getRecord("user", "personID", ID);
        try{
            if(rs.first()){
                return new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("gender"),
                    rs.getString("personID"));
            } else {
                System.out.println("Result set was empty\n");
            }

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.err.println("Couldn't translate result set to user object\n");
        }

        return null;
    }

    /**
     * Deletes a user given their username.
     * @param username the username we are deleting from database.
     */
    public void delete(String username){
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(deleteSQL)){
            prepStmt.setString(1,username);
            prepStmt.executeQuery();
            DB.closeConnection(true);

        } catch (DataAccessException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't open connection\n");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't prepare statement or execute delete.");
        }
    }

    /**
     * Returns all the users in the Database.
     * @return A list of User objects.
     */
    public LinkedList<User> findAll(){
        LinkedList<User> users = new LinkedList<>();

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(findAllSQL)){
            ResultSet rs = prepStmt.executeQuery();
            if(rs.first()) {
                do {
                    User u = new User(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));

                    users.add(u);

                } while (rs.next());
            } else {
                System.out.println("Result set was empty.\n");
            }

        } catch (DataAccessException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't get connection");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Either couldn't prepare statement or translate data to objects.");
        }

        return users;

    }

    /**
     * Clears all data from User table.
     */
    public void clear(){
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(clearSQL)){
            prepStmt.executeQuery();
        } catch (DataAccessException ex){
            System.out.println(ex.getMessage());
            System.out.println("Couldn't get connection\n");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Couldn't prepare statement or clear user table data.\n");
        }
    }

}
