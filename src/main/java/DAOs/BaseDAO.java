package DAOs;

import java.io.File;
import java.sql.*;

/**
 * abstracting out the DAO
 */
public class BaseDAO {
    public Database DB;

    /**
     * Constructor, opens DB connection.
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
}