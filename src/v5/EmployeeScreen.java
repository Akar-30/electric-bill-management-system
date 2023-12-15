package v5;

import java.sql.Connection;
import java.util.Scanner;


public class EmployeeScreen {

    private final Connection connection;


    public EmployeeScreen(Connection connection) {
        this.connection = connection;
    }

    void handleOptions() {
        Scanner scanner = new Scanner(System.in);
        EmployeeDbControl employeeDbControl = new EmployeeDbControl(connection);
        int employeeChoice;
        do {
            System.out.println("Employee Home");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Edit");
            System.out.println("5. Go back");
            System.out.print("Enter your choice: ");
            employeeChoice = scanner.nextInt();

            switch (employeeChoice) {
                case 1 -> {

                    System.out.print("Enter employee name: ");
                    scanner.nextLine();
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
                    System.out.print("Enter employee salary:(in IQD) ");
                    double empSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    String empType = scanner.nextLine();

                    Employee newEmployee = new Employee(empName, empNickname, empGender, empPhoneNumber, empAddress, empEmail, empSalary, empType);
                    employeeDbControl.addEmployeeToDatabase(newEmployee);
                    System.out.println("Employee added successfully!");
                }// Add Employee
                case 2 -> employeeDbControl.viewEmployeesFromDatabase();// View Employees
                case 3 -> {
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean found = false;
                    employeeDbControl.deleteEmployeeFromDatabase(deleteId);
                    if (!found) {
                        System.out.println("Employee with ID " + deleteId + " not found.");
                    }

                }// Delete Employee
                case 4 -> employeeDbControl.getUserInputAndUpdate();// Edit Employee
                case 5 -> System.out.println("Going back to main menu...");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (employeeChoice != 5);
    }
}
