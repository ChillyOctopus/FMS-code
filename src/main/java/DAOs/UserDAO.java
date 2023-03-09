package DAOs;
import Models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


/**
 * In-between for User models and database.
 */
public class UserDAO extends BaseDAO{
    /**
     * Inserting a User object into the database.
     * @param user the object we are inserting.
     * @throws DataAccessException
     */
    public void insert(@NotNull User user) throws DataAccessException {
        String sql = "INSERT INTO User VALUES ? ? ? ? ? ? ?";
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
        try (PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql))
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
            throw new DataAccessException("Failed to insert User.\n");
        }
    }

    /**
     * Returns a single user based on ID.
     * @param ID the ID we are searching for.
     * @return the User object from the database.
     * @throws DataAccessException
     */
    public User find(String ID) throws DataAccessException{
        String sql = "SELECT * FROM User WHERE personID = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,ID);
            ResultSet rs = prepStmt.executeQuery();

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
            throw new DataAccessException("Couldn't translate result set to user object\n");
        }

        return null;
    }

    /**
     * Returns all the users in the Database.
     * @return A list of User objects.
     * @throws DataAccessException
     */
    public LinkedList<User> findAll() throws DataAccessException{
        String sql = "SELECT * FROM User";
        LinkedList<User> users = new LinkedList<>();

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
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

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Either couldn't prepare statement or translate data to objects.");
        }

        return users;

    }

    /**
     * Deletes a user given their username.
     * @param username the username we are deleting from database.
     * @throws DataAccessException
     */
    public void delete(String username) throws DataAccessException {
        String sql = "DELETE FROM User WHERE username = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,username);
            prepStmt.executeQuery();
            DB.closeConnection(true);

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or execute delete.");
        }
    }

    /**
     * Clears all data from User table.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
        String sql = "DELETE FROM User";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or clear user table data.\n");
        }
    }

}
