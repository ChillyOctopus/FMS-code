package DAOs;

import Models.Authtoken;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * In-between for Authtoken models and database.
 */
public class AuthtokenDAO extends BaseDAO {

    /**
     * Inserting a token object into the database.
     * @param token the token we are inserting.
     * @throws DataAccessException
     */
    public void insert(Authtoken token) throws DataAccessException{
        String sql = "INSERT INTO Authtoken (authtoken, username) VALUES (?,?)";

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,token.getAuthtoken());
            prepStmt.setString(2,token.getUsername());
            prepStmt.executeUpdate();
        }catch(SQLException ex){
            ex.getMessage();
            DB.closeConnection(false);
            throw new DataAccessException("Unable to insert Authtoken.");
        }

        DB.closeConnection(true);
    }

    /**
     * Checks to see if we have the token in the database.
     * @param tokenString The Authtokens string we are checking for in database.
     * @return the ID of the User who has the token.
     */
    public String findUser(String tokenString) throws DataAccessException{
        String sql = "SELECT * FROM Authtoken WHERE authtoken = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,tokenString);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                DB.closeConnection(false);
                return rs.getString(1);
            } else {
                DB.closeConnection(false);
                return null;
            }
        } catch(SQLException ex){
            ex.getMessage();
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't retrieve userID");
        }
    }

    /**
     * Returns a list of authtokens (likely just one) which match the username we are looking for.
     * @param username the username we are searching for an authtoken for
     * @return the list of authtokens (likely just one) that matches the username
     */
    public List<Authtoken> findAuths(String username) throws DataAccessException{
        List<Authtoken> authList = new ArrayList<>();
        String sql = "SELECT * FROM Authtoken WHERE username = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,username);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                Authtoken a = new Authtoken(rs.getString(1),rs.getString(2));
                authList.add(a);
            }
        } catch(SQLException ex){
            ex.getMessage();
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't retrieve authtokens");
        }

        DB.closeConnection(false);
        return authList;
    }

    /**
     * get all the Authtokens in the database.
     * @return A list of the authtokens we have.
     */
    public List<String> findAll() throws DataAccessException {
        List<String> authList = new ArrayList<>();
        String sql = "SELECT * FROM Authtoken";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                authList.add(rs.getString(1));
            }
        } catch(SQLException ex){
            ex.getMessage();
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't retrieve authtokens");
        }

        DB.closeConnection(false);
        return authList;
    }

    /**
     * Delete a single authtoken given ID
     * @param token the token we are searching for.
     * @throws DataAccessException
     */
    public void delete(String token) throws DataAccessException{
        String sql = "DELETE FROM Authtoken WHERE authtoken = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,token);
            prepStmt.executeQuery();
            DB.closeConnection(true);

        } catch (SQLException ex){
            DB.closeConnection(false);
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or execute delete.");
        }
    }

    /**
     * Clearing all the Authtoken data from database.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
        String sql = "DELETE FROM Authtoken";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            DB.closeConnection(false);
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or clear authtoken table data.\n");
        }
        DB.closeConnection(true);
    }
}
