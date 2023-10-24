package models;

//import java.util.Date;

public class Customer {
    private final String name;
    private final String phoneNumber;
    private final String address;
    private final String subscriptionType;
    private final double subscriptionQuantity;


    public Customer( String name,
     String phoneNumber,
     String address,
     String subscriptionType,
     double subscriptionQuantity
                     //Date startDay,
    ){

        //private Date startDay;
        this.address=address;
        this.name=name;
        //this.startDay=startDay;
        this.subscriptionQuantity=subscriptionQuantity;
        this.subscriptionType=subscriptionType;
        this.phoneNumber=phoneNumber;

    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getAddress() {
        return address;
    }

    public double getSubscriptionQuantity() {
        return subscriptionQuantity;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

}

