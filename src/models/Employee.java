package models;

public class Employee {



    private String id;
    private String name;
    private boolean isManager;
    private String phoneNumber;
    private double salary;

    public Employee(String id,String name,boolean isManager,String phoneNumber,double salary){
        this.id =id;
        this.isManager=isManager;
        this.name=name;
        this.salary=salary;
        this.phoneNumber=phoneNumber;
    }




    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
