package v6;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection ConnectDB(){
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/test1","root","");
            return con;
        } catch (Exception e) {
            System.out.println("database not connected");
            return null;
        }
    }

}
