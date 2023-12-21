package v5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagingScreen {
    private final String loggedInEmployeeName;
    private final int loggedInEmployeeID;

    public ManagingScreen(int loggedInEmployeeID,String loggedInEmployeeName){
        this.loggedInEmployeeID = loggedInEmployeeID;
        this.loggedInEmployeeName = loggedInEmployeeName;
    }

    public void display() {

        System.out.println("Welcome to the Managing Screen");
        System.out.println("Logged-in Employee: " + loggedInEmployeeName + " (ID: " + loggedInEmployeeID + ")");
        showCustomers();

    }

    private static void showCustomers() {
        String dbUrl = "jdbc:mysql://localhost/oop";
        String dbUsername = "root";
        String dbPassword = "1234";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT idcustomer, fName, nickname, subscriptionType, ampere, status FROM customer";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("Customers:");
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-30s %-20s %-10s %-10s %-15s%n",
                        "ID", "Name", "Subscription Type", "Ampere", "Amount", "Status");
                System.out.println("----------------------------------------------------------------------------------------------------");

                while (resultSet.next()) {
                    String customerID = resultSet.getString("idcustomer");
                    String fName = resultSet.getString("fName");
                    String nickname = resultSet.getString("nickname");
                    String name = fName + " " + nickname;
                    String subscriptionType = resultSet.getString("subscriptionType");
                    int ampere = resultSet.getInt("ampere");
                    double amount = subscriptionType.equals("24-Hours") ?ampere * 10000:ampere*5000;
                    String status = resultSet.getString("status");

                    System.out.printf("%-10s %-30s %-20s %-10s %-10.2f %-1s%n",
                            customerID, name, subscriptionType, ampere, amount, status);
                }
                payed();
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    private static void payed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Payed Method - Update Customer Status");
        System.out.print("Enter Customer ID to mark as paid: ");
        String customerID = scanner.nextLine();

        String dbUrl = "jdbc:mysql://localhost/oop";
        String dbUsername = "root";
        String dbPassword = "1234";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String updateQuery = "UPDATE customer SET status = 'Payed' WHERE idcustomer = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, customerID);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Customer status updated to 'Paid' successfully.");
                } else {
                    System.out.println("No customer found with the provided ID.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

}

