package v5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginScreen {

    private final Connection connection;

    public LoginScreen(Connection connection) {
        this.connection = connection;
    }

    public void display(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {

            System.out.println("Welcome to ElectricBill Management System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
            switch (choice){
                case 1: login();
                case 2: register();
                case 3: System.out.println("Exiting LOGIN SCREEN.");
                default:
                    System.out.println("Invalid Input");
            }
        } while (choice !=3);
    }

    public void register(){
        EmployeeDbControl employeeDbControl = new EmployeeDbControl(connection);
        System.out.print("Enter employee name: ");
        Scanner scanner = new Scanner(System.in);
        String empName = scanner.nextLine();
        System.out.print("Enter employee nickname: ");
        String empNickname = scanner.nextLine();
        System.out.print("Enter employee gender: ");
        String empGender = scanner.nextLine();
        System.out.print("Enter employee phone number: ");
        String empPhoneNumber = scanner.nextLine();
        System.out.print("Enter employee address: ");
        String empAddress = scanner.nextLine();
        System.out.print("Enter employee email: ");
        String empEmail = scanner.nextLine();
        System.out.print("Enter employee type (Full-time, Part-time): ");
        String empType = scanner.nextLine();
        System.out.print("Enter employee salary:(in IQD) ");
        double empSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline


        Employee newEmployee = new Employee(empName, empNickname, empGender, empPhoneNumber, empAddress, empEmail, empSalary, empType);
        employeeDbControl.addEmployeeToDatabase(newEmployee);
        System.out.println("Employee added successfully!");
        employeeDbControl.retrieveLastEmployee();

    }// Add Employee


    public void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login Screen");

        System.out.print("Enter Employee ID: ");
        String enteredID = scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String enteredName = scanner.nextLine();

        if (authenticate(enteredID, enteredName)) {

            System.out.println("Login successful!");
            int id = Integer.parseInt(enteredID);
            MainScreen mainScreen = new MainScreen(id,enteredName);
            mainScreen.mainScreen();
        } else {
            System.out.println("Login failed. Invalid credentials.");
            // Handle failed login attempt
        }
    }

    private static boolean authenticate(String enteredID, String enteredName) {
        String dbUrl = "jdbc:mysql://localhost/oop";
        String dbUsername = "root";
        String dbPassword = "1234";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT * FROM employee WHERE idEmployee = ? AND fName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, enteredID);
                preparedStatement.setString(2, enteredName);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next(); // If a record is found, authentication is successful
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            return false; // Authentication fails due to a database error
        }
    }
}
