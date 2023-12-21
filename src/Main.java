import v5.*;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        Connection dbConnection = null;
        try {
            MySQLConnector connector = new MySQLConnector();
            dbConnection = connector.getConnection();
            LoginScreen loginScreen = new LoginScreen(dbConnection);
            loginScreen.display();

            connector.closeConnection();
        } finally {
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}