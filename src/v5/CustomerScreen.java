package v5;

import java.sql.Connection;
import java.util.Scanner;


public class CustomerScreen {

    private final Connection connection;


    public CustomerScreen(Connection connection) {
        this.connection = connection;
    }

    void handleOptions() {
        Scanner scanner = new Scanner(System.in);
        CustomerDbControl customerDbControl = new CustomerDbControl(connection);
        int customerChoice;
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
                case 1 -> {

                    System.out.print("Enter customer name: ");
                    scanner.nextLine();
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
                    Customer newCustomer = new Customer(customerName, customerNickname,customerGender,customerPhoneNumber,customerAddress,customerEmail,customerSubType,customerSubQuantity,0);
                    customerDbControl.addCustomerToDatabase(newCustomer);
                    System.out.println("Customer added successfully!");

                }// Add Customer
                case 2 -> customerDbControl.viewCustomersFromDatabase();// View Customers
                case 3 -> {
                        System.out.print("Enter customer ID to delete: ");
                        int deleteId = scanner.nextInt();
                        boolean found = false;
                        customerDbControl.deleteCustomerFromDatabase(deleteId);
                        if (!found) {
                            System.out.println("Customer with ID " + deleteId + " not found.");
                        }

                }// Delete Customer
                case 4 -> customerDbControl.getUserInputAndUpdate();// Edit Customer
                case 5 -> System.out.println("Going back to main menu...");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (customerChoice != 5);
    }
}
