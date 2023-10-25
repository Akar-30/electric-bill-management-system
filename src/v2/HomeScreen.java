package v2;

import models.CustomerControl;

import java.util.Scanner;

public class HomeScreen {
    CustomerControl cc =  new CustomerControl();
    public void navigator(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Add\tUpdate\tDelete\tView\tEmployee Screen\tQuit\n1.\t2.\t3.\t4.\t5.\t\t-1\n");
        int option= scan.nextInt();
        switch (option){
            case 1:
                add();
                return;
            case 2:
                update();
                return;
            case 3:
                delete();
                return;
            case 4:
                view();
                return;
            case 5:
                employee();
                return;
            default:
                return;

        }
    }

    public void add(){
            cc.createCustomer();
    }
    public void update(){

    }
    public void delete(){

    }
    public void view(){

    }
    public void employee(){

    }
}
