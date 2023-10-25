package v3;

import java.util.Date;
import java.util.Scanner;

public class Customer extends Person {

    private  String subscriptionType;
    private  double subscriptionQuantity;


    public Customer() {
        super();
    }

    public void setCustomer(String subscriptionType,double subscriptionQuantity){
         this.subscriptionType=subscriptionType;
         this.subscriptionQuantity=subscriptionQuantity;
    }

    @Override
    public void input() {
        super.input();
        Scanner scan = new Scanner(System.in);
        System.out.println("Subscription Type:");
        String subscriptionType = scan.nextLine();
        System.out.println("subscription Quantity: (in number) ");
        double subscriptionQuantity = scan.nextDouble();
        setCustomer(subscriptionType,subscriptionQuantity);
    }

    public void display(){
        System.out.println(super.getId()+"\t\t"+getName() + "\t\t" + getAddress() + "\t\t" + getPhoneNumber()+ "\t\t" +subscriptionType + "\t\t" + subscriptionQuantity);
    }
}
