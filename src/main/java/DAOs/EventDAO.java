package DAOs;

import java.sql.*;
import Models.Event;
/**
 * In-between for Event models and database.
 */
public class EventDAO extends BaseDAO{

    /**
     * Inserting an Event object into our database.
     * @param event The event object we are inserting in the database.
     * @throws DataAccessException
     */
    public void insert(Event event) throws DataAccessException {
        //We can structure our string to be similar to a sql command, but if we insert question
        //marks we can change them later with help from the statement
        String sql = "INSERT INTO Event (eventID, associatedUsername, personID, latitude, longitude, " +
                "country, city, eventType, year) VALUES(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)) {
            //Using the statements built-in set(type) functions we can pick the question mark we want
            //to fill in and give it a proper value. The first argument corresponds to the first
            //question mark found in our sql String
            prepStmt.setString(1, event.getEventID());
            prepStmt.setString(2, event.getAssociatedUsername());
            prepStmt.setString(3, event.getPersonID());
            prepStmt.setFloat(4, event.getLatitude());
            prepStmt.setFloat(5, event.getLongitude());
            prepStmt.setString(6, event.getCountry());
            prepStmt.setString(7, event.getCity());
            prepStmt.setString(8, event.getEventType());
            prepStmt.setInt(9, event.getYear());

            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DataAccessException("Error encountered while inserting an event into the database");
        }
    }

    /**
     * Finding an Event inside our database.
     * @param eventID The ID of the event we are trying to find.
     * @return An event object.
     * @throws DataAccessException
     */
    public Event find(String eventID) throws DataAccessException {
        String sql = "SELECT * FROM Event WHERE eventID = ?";
        Event event;
        try (PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,eventID);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                event = new Event(rs.getString("eventID"), rs.getString("associatedUsername"),
                        rs.getString("personID"), rs.getFloat("latitude"), rs.getFloat("longitude"),
                        rs.getString("country"), rs.getString("city"), rs.getString("eventType"),
                        rs.getInt("year"));
                return event;
            } else {
                return null;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new DataAccessException("Couldn't locate single event.");
        }
    }

    /**
     * Clearing all the Event data from our database.
     * @throws DataAccessException
     */
    public void clear() throws DataAccessException {
        String sql = "DELETE FROM Event";
        try (PreparedStatement stmt = DB.getConnection().prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DataAccessException("Error encountered while clearing the event table");
        }
    }
}