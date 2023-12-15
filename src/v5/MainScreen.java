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

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("Welcome to Control Panel");
                System.out.println("1. Employee Screen");
                System.out.println("2. Customer Screen");
                System.out.println("3. Reports");
                System.out.println("4. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> employeeControl.handleOptions();
                    case 2 -> customerControl.handleOptions();
                    //case 3 -> reports(employeeControl.getEmployees(),customerControl.getCustomers());
                    case 4 -> System.out.println("Exiting Control Panel. Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 4);

        //Customer newCustomer = new Customer(/* Customer details */);
        //customerControl.addCustomerToDatabase(newCustomer);

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


    private static void reports(ArrayList<Employee> employees, ArrayList<Customer> customers){
        Report report = new Report(employees,customers);
        report.generateReport();
    }

}
