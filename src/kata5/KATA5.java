package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.sqlite.JDBC");
//        Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");
        System.out.println("Opened database successfully");

        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from PEOPLE");

        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));

        }
        stmt.close();
        c.close();
    }

}
