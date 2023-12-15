package v6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CustomerControl {
    private final ArrayList<Customer> customers = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void handleOptions() {
        Scanner scanner = new Scanner(System.in);
        int customerChoice;
        con = DatabaseConnection.ConnectDB();

        do {
            System.out.println("Customer Home");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Edit");
            System.out.println("5. Go back");
            System.out.print("Enter your choice: ");
            customerChoice = scanner.nextInt();

            switch (customerChoice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    deleteCustomer(scanner);
                    break;
                case 4:
                    editCustomer(scanner);
                    break;
                case 5:
                    System.out.println("Going back to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (customerChoice != 5);
    }

    private void addCustomer(Scanner scanner) {
        System.out.print("Enter customer id: ");
        int customerID = scanner.nextInt();
        System.out.print("Enter customer name: ");
        scanner.nextLine(); // Consume newline
        String customerName = scanner.nextLine();

        System.out.print("Enter customer nickname: ");
        String customerNickname = scanner.nextLine();

        System.out.print("Enter customer gender: ");
        String customerGender = scanner.nextLine();

        System.out.print("Enter customer phone number: ");
        String customerPhoneNumber = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Enter customer subscription type (1. 24 hour , 2. only day ): ");
        String customerSubType = scanner.nextLine();

        System.out.print("Enter customer Ampere number (in Number): ");
        int customerSubQuantity = scanner.nextInt();

        // Creating a database connection
        con = DatabaseConnection.ConnectDB();

        // SQL query to insert customer data
        String sql = "INSERT INTO customers (name, nickname, gender, phone_number, address, email, subscription_type, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, customerID);
            pst.setString(2, customerName);
            pst.setString(3, customerNickname);
            pst.setString(4, customerGender);
            pst.setString(5, customerPhoneNumber);
            pst.setString(6, customerAddress);
            pst.setString(7, customerEmail);
            pst.setString(8, customerSubType);
            pst.setInt(9, customerSubQuantity);

            // Execute the query to insert customer data
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer added successfully!");
            } else {
                System.out.println("Failed to add customer.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private void viewCustomers() {
        // View customers logic here
        // ...
        if (customers.isEmpty()) {
            System.out.println("No customers to display.");
        } else {
            // Display customers
            // ...
        }
    }

    private void deleteCustomer(Scanner scanner) {
        // Delete customer logic here
        // ...
        if (customers.isEmpty()) {
            System.out.println("No customers to delete.");
        } else {
            // Delete customer
            // ...
        }
    }

    private void editCustomer(Scanner scanner) {
        // Edit customer logic here
        // ...
        if (customers.isEmpty()) {
            System.out.println("No customers to edit.");
        } else {
            // Edit customer
            // ...
        }
    }

    private void handleEditing(Customer customer, String attribute, String editing) {
        // Handle editing logic here
        // ...
        System.out.println(attribute != null ? "Customer " + attribute + " is updated successfully" : "Nothing updated");
        System.out.println("Customer details updated successfully!");
    }

    private String editCustomer(Customer customer, Scanner scanner) {
        // Edit customer logic here
        // ...
        return null; // Return updated attribute
    }

    public static void main(String[] args) {
        // Create instance of CustomerScreen and run handleOptions()
        CustomerControl customerControl = new CustomerControl();
        customerControl.handleOptions();
    }
}
