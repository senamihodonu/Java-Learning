package dmv.portal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DMVPortal {
    public DMVPortal(){
        System.out.println("Division of Motor Vehicles");
        String sql= "CREATE TABLE IF NOT EXISTS drivers_licence (" +
                "licence_id VARCHAR(20) PRIMARY KEY NOT NULL UNIQUE,"+
                "first_name TEXT NOT NULL,"+
                "last_name TEXT NOT NULL,"+
                "date_of_birth DATE,"+
                "county TEXT NOT NULL,"+
                "state TEXT NOT NULL,"+
                "issue DATE,"+
                "expiration DATE"+
                ");";
        try {
            Connection sqlConn = SQLiteConn.connect();
            Statement stmt = sqlConn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Entering new driver
     * @param firstname
     * @param lastname
     * @param dob
     * @param county
     * @param state
     */
    public void newDriver(String firstname, String lastname, String dob, String county, String state){
        LicenceNumberGenerator lNG = new LicenceNumberGenerator();
        String licenceID = lNG.generator();
        LocalDate iss = LocalDate.now();
        String issueDate = String.valueOf(iss);
        LocalDate exp = iss.plusYears(8);
        String expirationDate = String.valueOf(exp);

        Connection sqlConn = SQLiteConn.connect();
        try {
            Statement statement = sqlConn.createStatement();
        String sql = "INSERT INTO drivers_licence(licence_id,first_name, last_name, date_of_birth, county, state, issue, expiration) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = sqlConn.prepareStatement(sql);
        pstmt.setString(1, licenceID);
        pstmt.setString(2, firstname);
        pstmt.setString(3, lastname);
        pstmt.setString(4, dob);
        pstmt.setString(5, county);
        pstmt.setString(6, state);
        pstmt.setString(7, issueDate);
        pstmt.setString(8, expirationDate);
        pstmt.executeUpdate();
        sqlConn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDriver(String licenceID){

    }

    public void getAllCustomers(){
        System.out.println("All Customers");
    }

    public static void main(String[] args){
        DMVPortal dmvPortal = new DMVPortal();
        dmvPortal.newDriver("Senami", "Hodonu", "1988-07-26", "Ada", "Idaho");
        dmvPortal.newDriver("Nurudeen", "Ibrahim", "1989-01-14", "Ada", "Idaho");

    }
}
