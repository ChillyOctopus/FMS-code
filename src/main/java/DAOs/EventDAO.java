package DAOs;

import java.sql.*;
import java.util.LinkedList;

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
            DB.closeConnection(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
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
                DB.closeConnection(false);
                return event;
            } else {
                DB.closeConnection(false);
                return null;
            }
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            DB.closeConnection(false);
            throw new DataAccessException("Couldn't locate single event.");
        }
    }

    /**
     * Returns all events we have in the database
     * @param assocUserID the UserID we want to screen the events through
     * @return A list of events in the database
     * @throws DataAccessException
     */
    public LinkedList<Event> findAll(String assocUserID) throws DataAccessException{
        LinkedList<Event> events = new LinkedList<>();
        String sql = "SELECT * FROM Event WHERE associatedUsername = ?";

        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)){
            prepStmt.setString(1,assocUserID);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()) {
                do {
                    Event e = new Event(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getFloat(4),
                            rs.getFloat(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9));

                    events.add(e);

                } while (rs.next());
            }
            DB.closeConnection(false);
            return events;
        } catch (SQLException ex){
            DB.closeConnection(false);
            throw new DataAccessException("Either couldn't prepare statement or translate data to objects.");
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
            DB.closeConnection(true);
            return;
        } catch (SQLException ex) {
            ex.printStackTrace();
            DB.closeConnection(false);
            throw new DataAccessException("Error encountered while clearing the event table");
        }
    }
}