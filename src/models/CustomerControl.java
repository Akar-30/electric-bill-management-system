package models;

import java.util.ArrayList;
import java.util.Scanner;

import models.Customer;
public class CustomerControl {
    private final ArrayList<Customer>customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void createCustomer(){
        Scanner scanner=new Scanner(System.in);

        System.out.print("Name:..");
        String name=scanner.nextLine();
        System.out.print("nickName:..");
        String nickname=scanner.nextLine();
        System.out.print("Phone Number:..");
        String phoneNumber=scanner.nextLine();
        System.out.print("Address:..");
        String address=scanner.nextLine();
        System.out.print("Subscription Type:..");
        String subscriptionType=scanner.nextLine();
        System.out.print("Subscription Quantity:..(in digits)..");
        double subscriptionQuantity=scanner.nextDouble();

        Customer customer;
        customer = new Customer(name, nickname, phoneNumber,address,subscriptionType,subscriptionQuantity);
        addCustomer(customer);
    }

    public void update(int i){

    }

    public void displayAll (ArrayList<Customer> customers){
        for (Customer customer : customers) {
            System.out.println("ID \t\t\t"+customer.getUniqueId());
            System.out.println("Name \t\t\t" + customer.getName());
            System.out.println("nickName \t\t\t" + customer.getNickname());
            System.out.println("Phone Number \t" + customer.getPhoneNumber());
            System.out.println("Address \t\t" + customer.getAddress());
            System.out.println("Subscription Type \t" + customer.getSubscriptionType());
            System.out.println("Subscription Quantity " + customer.getSubscriptionQuantity());
        }
    }

}
