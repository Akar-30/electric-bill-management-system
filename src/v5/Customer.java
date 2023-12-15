package v5;

import java.util.Random;

class Customer extends Person {
    private final String subscriptionType;
    private final int subscriptionQuantity;
    private final String status;
    private final double balance;

    public Customer(String name, String nickname, String gender, String phoneNumber, String address, String email, String subscriptionType, int subscriptionQuantity, double balance) {
        super( name, nickname,gender, phoneNumber, address, email);
        this.subscriptionQuantity=subscriptionQuantity;
        this.subscriptionType=subscriptionType;
        this.balance = balance;
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        status = randomBoolean?"Payed":"Not Payed";
    }

    // Getters and Setters for Customer properties

    public double getBalance() {
        return balance;
    }


    public String getSubscriptionType() {
        return subscriptionType;
    }

    public String getStatus() {
        return status;
    }

    public int getSubscriptionQuantity() {
        return subscriptionQuantity;
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }


    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getNickname() {
        return super.getNickname();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setNickname(String nickname) {
        super.setNickname(nickname);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }
}