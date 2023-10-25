package v3;

import java.util.Scanner;

public class PartTimeEmployee extends Employee{
    private double salaryRate;

    public PartTimeEmployee() {
        super();
    }

    public void setSalaryRate(double workingHour) {
        salaryRate = workingHour*8;
    }

    public double getSalaryRate() {
        return salaryRate;
    }
    public void input(){
        Scanner scan = new Scanner(System.in);
        super.input();
        System.out.println("Working Hour:");
        double salary = scan.nextDouble();
        setSalaryRate(salary);
    }
    public void display(){
        super.display();
        System.out.println(id/2+"\t\t"+getName() + "\t\t" + getAge() + "\t\t" + getSalaryRate());
    }
}
