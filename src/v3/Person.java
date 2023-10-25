package v3;

import java.util.Scanner;

public class Person {


    private static int nextId=1;
    final int id;
    private  String name;
    private  String nickname;
    private  String phoneNumber;
    private  String address;
    private String email;

    public Person() {
        this.id=nextId++;
    }


    public void setPerson( String name, String nickname, String address, String pNumber, String email){
        this.name=name;
        this.nickname=nickname;
        this.address=address;
        this.email=email;
        this.phoneNumber=pNumber;
    }

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Nickname:");
        String nickname = scan.nextLine();
        System.out.println("Address:");
        String address = scan.nextLine();
        System.out.println("Phone Number:");
        String pNumber = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine();
        setPerson(name,nickname,address,email,pNumber);
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }


}

