package v4;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeControl {
    private final ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    private static String editEmployee(Employee employee, Scanner scanner) {
        System.out.println("What do you want to edit?");
        String attributeChoice = scanner.nextLine().toLowerCase();

        switch (attributeChoice) {
            case "name" -> {
                System.out.print("Enter new employee name: ");
                String newName = scanner.nextLine();
                employee.setName(newName);
            }
            case "nickname" -> {
                System.out.print("Enter new employee nickname: ");
                String newNickname = scanner.nextLine();
                employee.setNickname(newNickname);
            }
            case "gender" -> {
                System.out.print("Enter new employee gender: ");
                String newGender = scanner.nextLine();
                employee.setGender(newGender);
            }
            case "phone number" -> {
                System.out.print("Enter new employee phone number: ");
                String newPhoneNumber = scanner.nextLine();
                employee.setPhoneNumber(newPhoneNumber);
            }
            case "address" -> {
                System.out.print("Enter new employee address: ");
                String newAddress = scanner.nextLine();
                employee.setAddress(newAddress);
            }
            case "email" -> {
                System.out.print("Enter new employee email: ");
                String newEmail = scanner.nextLine();
                employee.setEmail(newEmail);
            }
            case "salary" -> {
                System.out.print("Enter new employee salary: ");
                double newSalary = scanner.nextDouble();
                employee.setSalary(newSalary);
            }
            case "type" -> {
                System.out.print("Enter new employee type (1. Full-time,  2. Part-time): ");
                scanner.nextLine(); // Consume newline
                String newType = scanner.nextLine();
                employee.setEmployeeType(newType);
            }
            default -> {
                System.out.println("Invalid attribute choice. Please enter a valid option.");
                attributeChoice = null;
            }
        }
        return attributeChoice;
    }


    void handleOptions() {

        Scanner scanner = new Scanner(System.in);
        int empChoice;
        do {
            System.out.println("Employee Home");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Edit");
            System.out.println("5. Go back");
            System.out.print("Enter your choice: ");
            empChoice = scanner.nextInt();

            switch (empChoice) {
                case 1 -> {
                    // Add Employee
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
                    System.out.print("Enter employee salary:(in IQD) ");
                    double empSalary = scanner.nextDouble();
                    System.out.print("Enter employee type (Full-time, Part-time): ");
                    scanner.nextLine(); // Consume newline
                    String empType = scanner.nextLine();

                    Employee newEmployee = new Employee(empName, empNickname, empGender, empPhoneNumber, empAddress, empEmail, empSalary, empType);
                    employees.add(newEmployee);
                    System.out.println("Employee added successfully!");
                }
                case 2 -> {
                    // View Employees
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("Employees:");
                        for (Employee employee : employees) {
                            System.out.println("ID: " + employee.getId() +
                                    ", Name: " + employee.getName() +
                                    ", Nickname: " + employee.getNickname() +
                                    ", Phone Number: " + employee.getPhoneNumber() +
                                    ", Address: " + employee.getAddress() +
                                    ", Email: " + employee.getEmail() +
                                    ", Salary: " + employee.getSalary() +
                                    ", Type: " + employee.getEmployeeType());
                        }
                    }
                }
                case 3 -> {
                    // Delete Employee
                    if (employees.isEmpty()) {
                        System.out.println("No employees to delete.");
                    } else {
                        System.out.print("Enter employee ID to delete: ");
                        int deleteId = scanner.nextInt();
                        boolean found = false;
                        for (Employee employee : employees) {
                            if (employee.getId() == deleteId) {
                                employees.remove(employee);
                                found = true;
                                System.out.println("Employee deleted successfully!");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Employee with ID " + deleteId + " not found.");
                        }
                    }
                }
                case 4 -> {
                    // Edit Employee
                    if (employees.isEmpty()) {
                        System.out.println("No employees to edit.");
                    } else {
                        System.out.print("Enter employee ID to edit: ");
                        int editId = scanner.nextInt();
                        boolean found = false;
                        for (Employee employee : employees) {
                            if (employee.getId() == editId) {
                                scanner.nextLine(); // Consume newline
                                String editing;
                                do {
                                    String attribute = editEmployee(employee, scanner);
                                    System.out.println(attribute != null ? "Employee " + attribute + " is updated successfully" : "Nothing updated");

                                    System.out.println("\nDo you want to edit more? (yes, no)");
                                    editing = scanner.nextLine().toLowerCase();
                                } while (editing.equals("yes"));

                                System.out.println("Employee details updated successfully!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Employee with ID " + editId + " not found.");
                        }
                    }
                }
                case 5 -> System.out.println("Going back to main menu...");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (empChoice != 5);
    }

}
