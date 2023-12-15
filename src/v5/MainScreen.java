package v5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainScreen {
    public void mainScreen() {

        Connection dbConnection = null;
        try {
            MySQLConnector connector = new MySQLConnector();
            dbConnection = connector.getConnection();

            CustomerScreen customerControl = new CustomerScreen(dbConnection);
            EmployeeScreen employeeControl = new EmployeeScreen(dbConnection);
            Report report = new Report(dbConnection);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("WELCOME TO MAIN SCREEN");
                System.out.println("1. Employee Screen");
                System.out.println("2. Customer Screen");
                System.out.println("3. Reports");
                System.out.println("4. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> employeeControl.handleOptions();
                    case 2 -> customerControl.handleOptions();
                    case 3 -> report.generateReport();
                    case 4 -> System.out.println("Exiting MAIN SCREEN. Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 4);

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
