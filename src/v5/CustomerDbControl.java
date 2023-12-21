package v5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDbControl {
    private final Connection connection;

    public CustomerDbControl(Connection connection) {
        this.connection = connection;
    }

    //Method to create new customer into the database
    public void addCustomerToDatabase(Customer customer) {
        String sql = "INSERT INTO customer (fName, nickname, gender, phoneNumber, address, email, subscriptionType, ampere, status, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getNickname());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getSubscriptionType());
            preparedStatement.setInt(   8, customer.getSubscriptionQuantity());
            preparedStatement.setString(9, customer.getStatus());
            preparedStatement.setDouble(10, customer.getBalance());

            preparedStatement.executeUpdate();
            System.out.println("Customer added successfully to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display table
    private static void displayTable(String[] data) {
        int numColumns = data.length;

        // Display table content
        int numRows = (int) Math.ceil((double) data.length / numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int index = i + j * numRows;
                if (index < data.length) {
                    System.out.printf("%-20s", data[index]);
                }
            }
            System.out.println();
        }
    }



    // Method to retrieve data as to table
    public void viewCustomersFromDatabase() {
        String sql = "SELECT idcustomer, fName, nickname, phoneNumber, subscriptionType, ampere, status, balance FROM customer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No customers found in the database.");
            } else {
                System.out.println("Customers in the database:");

                // Table headers
                String[] headers = {"ID", "Name", "Phone Number", "Type", "Ampere", "Status", "Balance"};
                displayTable(headers);

                while (resultSet.next()) {
                    int customerId = resultSet.getInt("idcustomer");
                    String firstName = resultSet.getString("fName");
                    String lastName = resultSet.getString("nickName");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String subscriptionType = resultSet.getString("subscriptionType");
                    int ampere = resultSet.getInt("ampere");
                    String status = resultSet.getString("status");
                    double balance = resultSet.getDouble("balance");
                    double amount = subscriptionType.equals("24-Hours") ?ampere * 10000:ampere*5000;
                    balance= status.equals("Not Payed") ?amount:0;
                    // Formatted row data
                    String[] rowData = {
                            String.valueOf(customerId),
                            firstName + " " + lastName,
                            phoneNumber,
                            subscriptionType,
                            String.valueOf(ampere),
                            status,
                            String.valueOf(balance)
                    };

                    displayTable(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to delete customer in the database
    public void deleteCustomerFromDatabase(int customerId) {
        String sql = "DELETE FROM customer WHERE idcustomer = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer with ID " + customerId + " deleted successfully.");
            } else {
                System.out.println("No customer found with ID " + customerId + ". No deletion performed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to Update
    public void updateCustomerInfo(int customerId, String columnName, String newValue) {
        String sql = "UPDATE customer SET " + columnName + " = ? WHERE idcustomer = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, customerId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer with ID " + customerId + " updated successfully.");
            } else {
                System.out.println("No customer found with ID " + customerId + ". No update performed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DISPLAY
    public void displayColumnTable() {
        String[] columnNames = {
                "Name", "Nickname", "Gender", "Phone Number",
                "Address", "Email", "Subscription Type",
                "Ampere", "Status", "Balance"
        };

        System.out.println("Column Index | Column Name");
        System.out.println("-------------|-------------");
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("%12d | %s\n", i + 1, columnNames[i]);
        }
    }

    // Method to get user input for ID, column index, and new value
    public void getUserInputAndUpdate() {
        Scanner scanner = new Scanner(System.in);
        CustomerDbControl custDbControl = new CustomerDbControl(connection);

        // Display the table of column names with index numbers
        displayColumnTable();

        // Get user input for ID, column index, and new value
        System.out.print("\nEnter customer ID: ");
        int customerId = scanner.nextInt();

        System.out.print("Enter column index to update: ");
        int columnIndex = scanner.nextInt();

        scanner.nextLine(); // Consume newline left from nextInt()

        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();

        // Call the update method with provided details
        custDbControl.updateCustomerInfo(customerId, getColumnName(columnIndex), newValue);
    }

    // Method to retrieve column name based on index
    private String getColumnName(int index) {
        String[] columnNames = {
                "fName", "nickname", "gender", "phoneNumber",
                "address", "email", "subscriptionType",
                "ampere", "status", "balance"
        };
        if (index > 0 && index <= columnNames.length) {
            return columnNames[index - 1];
        }
        return "";
    }

}
