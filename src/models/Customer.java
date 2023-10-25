package models;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
//import java.util.Date;

public class Customer {
    UUID uniqueId = UUID.randomUUID();

    private final String customerID=uniqueId.toString();
    private final String name;
    private final String nickname;
    private final String phoneNumber;
    private final String address;
    private final String subscriptionType;
    private final double subscriptionQuantity;
    private String email;
    private List<PaymentRecord> paymentHistory;
    private Date startDate;
    private Date subscriptionExpiryDate;
    private int ownerTeamMemberID;
    private String status;
    private Date subscriptionRenewalDate;


    public Customer(String name,
                    String nickname, String phoneNumber,
                    String address,
                    String subscriptionType,
                    double subscriptionQuantity
                    //Date startDay,
    ){
        this.nickname = nickname;

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

    public String getNickname() {
        return nickname;
    }
}

