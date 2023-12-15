package v5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDbControl {
    private final Connection connection;

    public EmployeeDbControl(Connection connection) {
        this.connection = connection;
    }

    //Method to create new Employee into the database
    public void addEmployeeToDatabase(Employee employee) {
        String sql = "INSERT INTO employee (fName, nickname, gender, phoneNumber, address, email, type, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getNickname());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getEmployeeType());
            preparedStatement.setDouble(8, employee.getSalary());


            preparedStatement.executeUpdate();
            System.out.println("Employee added successfully to the database!");
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
    public void viewEmployeesFromDatabase() {
        String sql = "SELECT idEmployee, fName, nickname, phoneNumber, type, salary FROM employee";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No Employees found in the database.");
            } else {
                System.out.println("Employees in the database:");

                // Table headers
                String[] headers = {"ID", "Name", "Phone Number", "Employee Type", "Salary"};
                displayTable(headers);

                while (resultSet.next()) {
                    int employeeId = resultSet.getInt("idEmployee");
                    String firstName = resultSet.getString("fName");
                    String lastName = resultSet.getString("nickName");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String employeeType = resultSet.getString("type");
                    double salary = resultSet.getDouble("salary");

                    // Formatted row data
                    String[] rowData = {
                            String.valueOf(employeeId),
                            firstName + " " + lastName,
                            phoneNumber,
                            employeeType,
                            String.valueOf(salary)
                    };

                    displayTable(rowData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to delete employee in the database
    public void deleteEmployeeFromDatabase(int employeeId) {
        String sql = "DELETE FROM employee WHERE idEmployee = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, employeeId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + employeeId + " deleted successfully.");
            } else {
                System.out.println("No Employee found with ID " + employeeId + ". No deletion performed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to Update
    public void updateEmployeeInfo(int employeeId, String columnName, String newValue) {
        String sql = "UPDATE Employee SET " + columnName + " = ? WHERE idEmployee = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, employeeId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + employeeId + " updated successfully.");
            } else {
                System.out.println("No Employee found with ID " + employeeId + ". No update performed.");
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
        EmployeeDbControl custDbControl = new EmployeeDbControl(connection);

        // Display the table of column names with index numbers
        displayColumnTable();

        // Get user input for ID, column index, and new value
        System.out.print("\nEnter Employee ID: ");
        int employeeId = scanner.nextInt();

        System.out.print("Enter column index to update: ");
        int columnIndex = scanner.nextInt();

        scanner.nextLine(); // Consume newline left from nextInt()

        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();

        // Call the update method with provided details
        custDbControl.updateEmployeeInfo(employeeId, getColumnName(columnIndex), newValue);
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
