package kata5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReaderDB {
    
    public static ArrayList<String> read () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        ArrayList<String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("Select MAIL from MAILS");
        
        String mail;
        while (rs.next()){
            mail=rs.getString("MAIL");
            if (!mail.contains("@"))continue;
            mailList.add(mail);
        }
        return mailList;
    }
}
