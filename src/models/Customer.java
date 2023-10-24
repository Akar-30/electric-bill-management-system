package models;

import java.util.Date;

public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String subscriptionType;
    private double subscriptionQuantity;
    private Date startDay;
    private double account;
    private String imageUrl;


    public Customer( String id,
     String name,
     String phoneNumber,
     String address,
     String subscriptionType,
     double subscriptionQuantity,
     //Date startDay,
     double account,
     String imageUrl){

        this.account=account;
        this.id=id;
        this.imageUrl=imageUrl;
        this.address=address;
        this.name=name;
        //this.startDay=startDay;
        this.subscriptionQuantity=subscriptionQuantity;
        this.subscriptionType=subscriptionType;
        this.phoneNumber=phoneNumber;

    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //public Date getStartDay() {
    //    return startDay;
    //}
    public double getAccount() {
        return account;
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

    public void setAccount(double account) {
        this.account = account;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSubscriptionQuantity(double subscriptionQuantity) {
        this.subscriptionQuantity = subscriptionQuantity;
    }

    //public void setStartDay(Date startDay) {
    //    this.startDay = startDay;
    //}

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}

