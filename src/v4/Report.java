package v4;
import java.util.ArrayList;

public class Report {
    private final ArrayList<Employee> employees;
    private final ArrayList<Customer> customers;

    public Report(ArrayList<Employee> employees, ArrayList<Customer> customers) {
        this.employees = employees;
        this.customers = customers;
    }

    public void generateReport() {
        showCustomerReport();
        showEmployeeReport();
        showFinancialReport();
    }

    private void showCustomerReport() {
        int totalCustomers = customers.size();
        int totalAmpere = 0;
        int totalDayOnly=0;
        int totalDayAmpere=0;
        double totalRevenue = 0;

        for (Customer customer : customers) {
            totalAmpere += customer.getSubscriptionQuantity();
            if ("1".equals(customer.getSubscriptionType())) {
                totalRevenue += (10000 * customer.getSubscriptionQuantity());
            } else {
                totalRevenue += (5000 * customer.getSubscriptionQuantity());
                totalDayOnly++;
                totalDayAmpere+=customer.getSubscriptionQuantity();
            }
        }

        System.out.println("Customer Report:");
        System.out.println("Total Customers: " + totalCustomers);
        System.out.println("Total Ampere: " + totalAmpere);
        System.out.println("Total Day Only: " + totalDayOnly);
        System.out.println("Total Day Only Ampere: "+totalDayAmpere);
        System.out.println("Total 24 Hour: " + (totalCustomers-totalDayOnly));
        System.out.println("Total Day Only Ampere: "+(totalAmpere-totalDayAmpere));
        System.out.println("Total Revenue: " + totalRevenue + " IQD");
        System.out.println();
    }

    private void showEmployeeReport() {
        int totalEmployees = employees.size();
        int totalPartTime = 0;
        int totalFullTime = 0;
        double totalSalary = 0;

        for (Employee employee : employees) {
            if ("2".equalsIgnoreCase(employee.getEmployeeType())) {
                totalPartTime++;
            } else {
                totalFullTime++;
            }
            totalSalary += employee.getSalary();
        }

        System.out.println("Employee Report:");
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Part-time Employees: " + totalPartTime);
        System.out.println("Total Full-time Employees: " + totalFullTime);
        System.out.println("Total Salary: " + totalSalary + " IQD");
        System.out.println();
    }

    private void showFinancialReport() {
        double totalCustomerRevenue = 0;
        double totalEmployeeSalary = 0;

        for (Customer customer : customers) {
            if ("1".equals(customer.getSubscriptionType())) {
                totalCustomerRevenue += (10000 * customer.getSubscriptionQuantity());
            } else {
                totalCustomerRevenue += (5000 * customer.getSubscriptionQuantity());
            }
        }

        for (Employee employee : employees) {
            totalEmployeeSalary += employee.getSalary();
        }

        double difference = totalCustomerRevenue - totalEmployeeSalary;

        System.out.println("Financial Report:");
        System.out.println("Total Customer Revenue: " + totalCustomerRevenue + " IQD");
        System.out.println("Total Employee Salary: " + totalEmployeeSalary + " IQD");
        System.out.println("Difference (Revenue - Salary): " + difference + " IQD");
    }
}
