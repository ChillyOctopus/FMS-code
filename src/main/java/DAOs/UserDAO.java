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
        String sql = "INSERT INTO User (username, password, email, firstName, lastName, gender, personID) VALUES (?,?,?,?,?,?,?)";
        //First check if anything the user has is null, needs to be a full object
        if(user.getUsername() == null ||
           user.getPassword() == null ||
           user.getEmail() == null ||
           user.getFirstName() == null ||
           user.getLastName() == null ||
           user.getGender() == null ||
           user.getPersonID() == null){
            DB.closeConnection(false);
            throw new DataAccessException("1 or more elements of user object are null - will not insert into database.");
        }

        if(usernameTaken(user.getUsername())){
            DB.closeConnection(false);
            throw new DataAccessException("Username already exists in database.");
        }

        try (PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,user.getUsername());
            prepStmt.setString(2,user.getPassword());
            prepStmt.setString(3,user.getEmail());
            prepStmt.setString(4,user.getFirstName());
            prepStmt.setString(5,user.getLastName());
            prepStmt.setString(6,user.getGender());
            prepStmt.setString(7,user.getPersonID());

            prepStmt.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
            throw new DataAccessException("Failed to insert User.");
        }

        DB.closeConnection(true);
    }

    /**
     * Returns a single user based on ID.
     * @param ID the ID we are searching for.
     * @return the User object from the database.
     * @throws DataAccessException
     */
    public User findByID(String ID) throws DataAccessException{
        String sql = "SELECT * FROM User WHERE personID = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,ID);
            ResultSet rs = prepStmt.executeQuery();

            if(rs.next()){
                DB.closeConnection(false);
                return new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("gender"),
                    rs.getString("personID"));
            } else {
                DB.closeConnection(false);
                throw new DataAccessException("Found no user with matching ID.");
            }

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't translate result set to user object\n");
        }
    }

    /**
     * Returns a single user based on username.
     * @param username the username we are searching for.
     * @return the User object from the database.
     * @throws DataAccessException
     */
    public User findByUsername(String username) throws DataAccessException{
        String sql = "SELECT * FROM User WHERE username = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            System.out.println("Prepared statement.");
            prepStmt.setString(1,username);
            System.out.println("Statement="+prepStmt);
            ResultSet rs = prepStmt.executeQuery();
            System.out.println("Have result set.");
            if(rs.next()){
                User u = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getString("personID"));
                DB.closeConnection(false);
                return u;
            } else {
                DB.closeConnection(false);
                throw new DataAccessException("Found no user with matching username.");
            }

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't translate result set to user object\n");
        }
    }

    /**
     * Determines whether username is taken already
     * @param username the username we are checking.
     * @return a boolean whether it is taken.
     * @throws DataAccessException
     */
    private boolean usernameTaken(String username) throws DataAccessException{
        String sql = "SELECT * FROM User WHERE username = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,username);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
            throw new DataAccessException("Error using SQL to find user by username. (UserDAO)\n");
        }
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
            if(rs.next()) {
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
                System.out.println("No Users found.\n");
            }

        } catch (SQLException ex){
            DB.closeConnection(false);
            System.out.println(ex.getMessage());
            throw new DataAccessException("Either couldn't prepare statement or translate data to objects.");
        }

        DB.closeConnection(false);
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
            prepStmt.executeUpdate();
            DB.closeConnection(true);

        } catch (SQLException ex){
            DB.closeConnection(false);
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
            prepStmt.executeUpdate();
            DB.closeConnection(true);
            return;
        } catch (SQLException ex) {
            DB.closeConnection(false);
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or clear user table data.\n");
        }
    }

}
