package DAOs;
import Models.Person;
import Models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
/**
 * In-between for Person models and database.
 */

public class PersonDAO extends BaseDAO{

    public final String insertSQL = "INSERT INTO Person VALUES ? ? ? ? ? ? ? ?";
    public final String findAllSQL = "SELECT * FROM Person WHERE userID = ?";
    public final String deleteSQL = "DELETE FROM Person WHERE personID = ?";
    public final String clearSQL = "DELETE FROM Person";

    /**
     * Inserting a Person object into database.
     * @param person the object we are inserting.
     * @throws DataAccessException
     */
    public void insert(@NotNull Person person) throws DataAccessException{
        if( person.getPersonID() == null ||
            person.getAssociatedUsername() == null ||
            person.getFirstName() == null ||
            person.getLastName() == null ||
            person.getGender() == null){
            System.out.println("1 or more required elements of person object are null - will not insert into database.\n");
            return;
        }

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(insertSQL)){
            prepStmt.setString(1,person.getPersonID());
            prepStmt.setString(2,person.getAssociatedUsername());
            prepStmt.setString(3,person.getFirstName());
            prepStmt.setString(4,person.getLastName());
            prepStmt.setString(5,person.getGender());
            prepStmt.setString(6,person.getFatherID());
            prepStmt.setString(7,person.getMotherID());
            prepStmt.setString(8,person.getSpouseID());

            prepStmt.executeQuery();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement, set strings, or execute query for insert person.\n");
        }
    }

    /**
     * Returns a single person from database based on ID
     * @param ID the ID of the person we want to summon from the database
     * @return a single person whose ID matches the parameter
     * @throws DataAccessException
     */
    public Person find(String ID) throws DataAccessException {
        ResultSet rs = getRecord("Person", "personID", ID);
        try{
            if(rs.first()){
                return new Person(
                        rs.getString("personID"),
                        rs.getString("associatedUsername"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getString("fatherID"),
                        rs.getString("motherID"),
                        rs.getString("spouseID"));
            } else {
                System.out.println("Result set was empty\n");
            }

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't translate result set to person object\n");
        }

        return null;
    }

    /**
     * Returns all people we have in the database
     * @param assocUserID the UserID we want to screen the people through
     * @return A list of people in the database
     * @throws DataAccessException
     */
    public LinkedList<Person> findAll(String assocUserID) throws DataAccessException{
        LinkedList<Person> persons = new LinkedList<>();

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(findAllSQL)){
            prepStmt.setString(1,assocUserID);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.first()) {
                do {
                    Person p = new Person(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8));

                    persons.add(p);

                } while (rs.next());
            } else {
                System.out.println("Result set was empty.\n");
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Either couldn't prepare statement or translate data to objects.");
        }

        return persons;
    }

    /**
     * Delete a single person given their ID
     * @param personID the ID we are searching for.
     * @throws DataAccessException
     */
    public void delete(String personID) throws DataAccessException{
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(deleteSQL)){
            prepStmt.setString(1,personID);
            prepStmt.executeQuery();
            DB.closeConnection(true);

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or execute delete.");
        }
    }

    /**
     * Clearing all the Person data from database.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException{
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(clearSQL)){
            prepStmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't prepare statement or clear person table data.\n");
        }
    }
}
