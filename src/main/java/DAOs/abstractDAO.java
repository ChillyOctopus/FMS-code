package DAOs;

import java.io.File;
import java.sql.*;

public class abstractDAO {

    Connection connection = null;

    /**
     * abstracting out the DAO, much can be handled in here.
     */
    public abstractDAO() {

        try {
            String dbName = "/home/adam/jacob/jacob_java/FMS.db";
            String connectionURL = "jdbc:sqlite:" + dbName;
            connection = DriverManager.getConnection(connectionURL);

        } catch (SQLException ex){
            System.out.println("SQL Exception thrown!\n");
            System.err.println(ex.getMessage());
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
        try(
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ) {
            pstmt.setString(1, tableName);
            pstmt.setString(2, pkey);
            pstmt.setString(3, pKeyVal);
            return pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Handled hah\n");
        }
        return null;
    }

}
