package dmv.portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class SQLiteConn {
    /**
     * Connect to a sample database
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            // db parameters
            String url = "jdbc:sqlite:dmv-database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}