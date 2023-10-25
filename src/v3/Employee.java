package v3;

import java.util.Scanner;

public class Employee extends Person {
    private int age;

    public Employee() {
        super();
    }


    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    @Override
    public void input(){
        Scanner scan = new Scanner(System.in);
        super.input();
        System.out.println("Age:");
        int age = scan.nextInt();
        setAge(age);
    }

    public void display(){
    }

    public String getAddress() {
        return super.getAddress();
    }

    public String getName() {
        return super.getName();
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getNickname() {
        return super.getNickname();
    }
}
