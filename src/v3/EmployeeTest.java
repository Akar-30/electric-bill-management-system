package v3;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {
    static Scanner scan = new Scanner(System.in);

    public static void addEmployee(ArrayList<Employee> employees){
        System.out.println("1. Part time Employee\n2. Full Time Employee");
        int option = scan.nextInt();
        Employee e = new Employee();
        switch (option){
            case 1 ->{
                e = new PartTimeEmployee();
                e.input();
            }
            case 2 ->{
                e = new FullTimeEmployee();
                e.input();
            }
            default -> System.out.println("wrong choice");
        }
        employees.add(e);
    }

    public static void viewEmployee(ArrayList<Employee> employees){
        System.out.println("ID\t\tName\t\tAge\t\tSalary\n**\t\t****\t\t***\t\t******");
        for (Employee e : employees) {
            e.display();
            System.out.println("**\t\t****\t\t***\t\t******");
        }
    }

    public static void addCustomer(ArrayList<Customer> customer){
        System.out.println("Adding Customers");
        Customer c = new Customer();
        c.input();
        customer.add(c);
    }

    public static void viewCustomer(ArrayList<Customer> customer){
        System.out.println("ID\t\tName\t\tAddress\t\tP.Number\t\tSub. Type\t\tQuantity\n**\t\t****\t\t*******\t\t*********\t\t********\t\t*********");
        for (Customer e : customer) {
            e.display();
            System.out.println("**\t\t****\t\t*******\t\t*********\t\t********\t\t*********");
        }
    }


    public static void customerScreen(ArrayList<Customer> customers){
        System.out.println("1. Add\n2. View");
        int option = scan.nextInt();
        while (option!=0){
            switch (option){
                case 1 -> addCustomer(customers);
                case 2 -> viewCustomer(customers);
                default -> System.out.println("Sorry, Wrong Choice");
            }
            System.out.println("\n\n1. Add\n2. View");
            option = scan.nextInt();
        }
    }

    public static void employeeScreen(ArrayList<Employee> employees){
        System.out.println("1. Add\n2. View\n-1. Back");
        int option = scan.nextInt();
        loop1:while (option!=-1){
            switch (option){
                case 1 -> addEmployee(employees);
                case 2 -> viewEmployee(employees);
                default -> {
                    System.out.println("Sorry, Wrong Choice");
                    break loop1;
                }
            }
            System.out.println("\n\n1. Add\n2. View\n-1. Back");
            option = scan.nextInt();
        }
    }

    public static void home(ArrayList<Customer> customers,ArrayList<Employee> employees){
        System.out.println("1. Customer\n2. Employee");
        int option = scan.nextInt();
        while (option!=-1){
            switch (option){
                case 1 -> customerScreen(customers);
                case 2 -> employeeScreen(employees);
                default -> System.out.println("Sorry, Wrong Choice");
            }
        }
    }



    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        home(customers,employees);

    }
}
