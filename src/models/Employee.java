package models;

public class Employee {

    private String employeeID;         // Unique identifier
    private String name;            // Full name
    private String email;           // Email address
    private String phoneNumber;     // Contact number
    private String managerID;          // ID of the manager to whom this employee reports
    private String notes;

    private boolean isManager;
    private double salary;

    public Employee(String employeeID,String name,String email,boolean isManager,String phoneNumber,String managerID,double salary){
        this.employeeID =employeeID;
        this.isManager=isManager;
        this.email=email;
        this.name=name;
        this.salary=salary;
        this.phoneNumber=phoneNumber;
        this.managerID=managerID;
    }




    public String getPhoneNumber() {
        return phoneNumber;
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


    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
