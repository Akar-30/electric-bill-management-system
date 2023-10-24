import java.util.ArrayList;
import java.util.Scanner;

import models.Customer;
public class CustomerControl {
    private final ArrayList<Customer>customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void createCustomer(){
        Scanner scanner=new Scanner(System.in);

        System.out.print("Name:..");
        String name=scanner.nextLine();
        System.out.print("Phone Number:..");
        String phoneNumber=scanner.nextLine();
        System.out.print("Address:..");
        String address=scanner.nextLine();
        System.out.print("Subscription Type:..");
        String subscriptionType=scanner.nextLine();
        System.out.print("Subscription Quantity:..");
        double subscriptionQuantity=scanner.nextDouble();

        Customer customer;
        customer = new Customer(name,phoneNumber,address,subscriptionType,subscriptionQuantity);
        addCustomer(customer);
    }

    public void displayAll (ArrayList<Customer> customers){
        for (Customer customer : customers) {
            System.out.println("Name \t\t\t" + customer.getName());
            System.out.println("Phone Number \t" + customer.getPhoneNumber());
            System.out.println("Address \t\t" + customer.getAddress());
            System.out.println("Subscription Type \t" + customer.getSubscriptionType());
            System.out.println("Subscription Quantity " + customer.getSubscriptionQuantity());
        }
    }


}
