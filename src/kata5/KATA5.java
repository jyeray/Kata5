package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KATA5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");
        System.out.println("Opened database successfully");

        Statement stmt = c.createStatement();
        String fileName="/home/joaquin/NetBeansProjects/KATA5/DATA/emailsfilev1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        
        String mail;
        while((mail=reader.readLine())!=null){
            String query="INSERT INTO MAILS(MAIL) VALUES ('"+mail+"')";
            stmt.executeUpdate(query);
        }
        
        
        ResultSet rs = stmt.executeQuery("Select * from PEOPLE");

        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("ID"));
            System.out.println("NAME = " + rs.getString("NAME"));

        }
        stmt.close();
        c.close();
    }

}
