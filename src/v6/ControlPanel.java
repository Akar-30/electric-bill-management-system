package v6;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlPanel {
    public void mainScreen() {
        CustomerControl customerControl= new CustomerControl();
        EmployeeControl employeeControl = new EmployeeControl();

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
                case 3 -> reports(employeeControl.getEmployees(),customerControl.getCustomers());
                case 4 -> System.out.println("Exiting Control Panel. Goodbye!");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void reports(ArrayList<Employee> employees, ArrayList<Customer> customers){
        Report report = new Report(employees,customers);
        report.generateReport();
    }

}
