package DAOs;

import java.io.File;
import java.sql.*;

public class BaseDAO {
    Database DB;

    /**
     * abstracting out the DAO
     */
    public BaseDAO() {
        DB = new Database();
        try {
            DB.openConnection();
        } catch(DataAccessException ex){
            System.out.println("Failed to open connection.");
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param tableName using a generic table
     * @param pkey using a primary key
     * @param pKeyVal checking a value
     * @return returns the result set for the classes to build on.
     */
    public ResultSet getRecord(String tableName, String pkey, String pKeyVal){
        String sql = "SELECT * FROM ? WHERE ? = ?";
        try(PreparedStatement prepStmt = DB.getConnection().prepareStatement(sql)) {

            prepStmt.setString(1, tableName);
            prepStmt.setString(2, pkey);
            prepStmt.setString(3, pKeyVal);

            return prepStmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failed to \"get record\" with SQL from BaseDAO\n");
        } catch (DataAccessException ex){
            System.out.println(ex.getMessage());
            System.out.println("Failed to get connection in \"get record\" of BaseDAO\n");
        }

        //If here, we threw an exception somewhere.
        return null;
    }

}