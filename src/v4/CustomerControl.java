package v4;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CustomerControl {
    private final ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private static String editCustomer(Customer customer, Scanner scanner){
        System.out.println("what do you want to edit?");
        String attributeChoice = scanner.nextLine().toLowerCase();

        switch (attributeChoice) {
            case "name" -> {
                System.out.print("Enter new customer name: ");
                String newName = scanner.nextLine();
                customer.setName(newName);
            }
            case "nickname" -> {
                System.out.print("Enter new customer nickname: ");
                String newNickname = scanner.nextLine();
                customer.setNickname(newNickname);
            }
            case "gender" -> {
                System.out.print("Enter new customer gender: ");
                String newGender = scanner.nextLine();
                customer.setNickname(newGender);
            }
            case "phone number" -> {
                System.out.print("Enter new customer phone number: ");
                String newPhoneNumber = scanner.nextLine();
                customer.setPhoneNumber(newPhoneNumber);
            }
            case "address" -> {
                System.out.print("Enter new customer address: ");
                String newAddress = scanner.nextLine();
                customer.setAddress(newAddress);
            }
            case "email" -> {
                System.out.print("Enter new customer email: ");
                String newEmail = scanner.nextLine();
                customer.setEmail(newEmail);
            }
            case "subscription type" -> {
                System.out.print("Enter new customer subscription type (1. 24 hour, 2. only day): ");
                String newSubType = scanner.nextLine();
                customer.setSubscriptionType(newSubType);
            }
            case "amp" -> {
                System.out.print("Enter new customer Ampere number (in Number): ");
                int newSubQuantity = scanner.nextInt();
                customer.setSubscriptionQuantity(newSubQuantity);
            }
            default -> {
                System.out.println("Invalid attribute choice. Please enter a valid option.");
                attributeChoice=null;
            }
        }
        return attributeChoice;
    }
    void handleOptions() {
        Scanner scanner = new Scanner(System.in);
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
                    // Add
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
                    Customer newCustomer = new Customer(customerName, customerNickname,customerGender,customerPhoneNumber,customerAddress,customerEmail,customerSubType,customerSubQuantity);
                    customers.add(newCustomer);
                    System.out.println("Customer added successfully!");
                }
                case 2 -> {
                    // View Customers
                    if (customers.isEmpty()) {
                        System.out.println("No customers to display.");
                    } else {
                        System.out.println("Customers:");
                        for (Customer customer : customers) {
                            double money;
                            if (Objects.equals(customer.getSubscriptionType(), "1")){
                                money=10000*customer.getSubscriptionQuantity();
                            }else{
                                money=5000*customer.getSubscriptionQuantity();
                            }
                            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Phone Number: " + customer.getPhoneNumber() + ", Sub Type (1. 24 hour , 2. only day ):  " + customer.getSubscriptionType() + ", Ampere: " + customer.getSubscriptionQuantity() + ", Total: " + money+"IQD , Status: "+customer.getStatus());
                        }
                    }
                }
                case 3 -> {
                    // Delete Customer
                    if (customers.isEmpty()) {
                        System.out.println("No customers to delete.");
                    } else {
                        System.out.print("Enter customer ID to delete: ");
                        int deleteId = scanner.nextInt();
                        boolean found = false;
                        for (Customer customer : customers) {
                            if (customer.getId() == deleteId) {
                                customers.remove(customer);
                                found = true;
                                System.out.println("Customer deleted successfully!");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Customer with ID " + deleteId + " not found.");
                        }
                    }
                }
                case 4 -> {
                    // Edit Customer
                    if (customers.isEmpty()) {
                        System.out.println("No customers to edit.");
                    } else {
                        System.out.print("Enter customer ID to edit: ");
                        int editId = scanner.nextInt();
                        boolean found = false;
                        for (Customer customer : customers) {
                            if (customer.getId() == editId) {
                                scanner.nextLine(); // Consume newline
                                String editing;
                                do{
                                    String attribute = editCustomer(customer,scanner);
                                    System.out.println(attribute!=null?"Customer "+attribute+" is updated Successfully":"nothing updated");

                                    System.out.println("\n do you want to edit more? (yes, no)");
                                    editing=scanner.nextLine().toLowerCase();
                                }while (editing.equals("yes"));


                                System.out.println("Customer details updated successfully!");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Customer with ID " + editId + " not found.");
                        }
                    }
                }
                case 5 -> System.out.println("Going back to main menu...");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (customerChoice != 5);
    }
}
