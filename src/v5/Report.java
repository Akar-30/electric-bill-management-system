package v5;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Report {

    private Connection connection;

    public Report(Connection connection) {
        this.connection = connection;
    }

    public void generateReport() {
        showCustomerReport();
        showEmployeeReport();
        showFinancialReport();
    }

    private void showCustomerReport() {
        int totalCustomers = 0;
        int totalAmpere = 0;
        int totalDayOnly = 0;
        int totalDayAmpere = 0;
        double totalRevenue = 0;

        String sql = "SELECT COUNT(*) AS total_customers, SUM(ampere) AS total_ampere, " +
                "SUM(CASE WHEN subscriptionType = 'Day-only' THEN 1 ELSE 0 END) AS total_day_only, " +
                "SUM(CASE WHEN subscriptionType = 'Day-only' THEN ampere ELSE 0 END) AS total_day_ampere, " +
                "SUM(CASE WHEN subscriptionType = '24-Hours' THEN 1 ELSE 0 END) AS total_24_hour, " +
                "SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere ELSE 0 END) AS total_24_hour_ampere, " +
                "SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere*10000 ELSE ampere*5000 END) AS total_revenue " +
                "FROM customer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalCustomers = resultSet.getInt("total_customers");
                totalAmpere = resultSet.getInt("total_ampere");
                totalDayOnly = resultSet.getInt("total_day_only");
                totalDayAmpere = resultSet.getInt("total_day_ampere");
                totalRevenue = resultSet.getDouble("total_revenue");
            }

            System.out.println("Customer Report:");
            System.out.println("Total Customers: " + totalCustomers);
            System.out.println("Total Ampere: " + totalAmpere);
            System.out.println("Total Day Only: " + totalDayOnly);
            System.out.println("Total Day Only Ampere: " + totalDayAmpere);
            System.out.println("Total 24 Hour: " + (totalCustomers - totalDayOnly));
            System.out.println("Total 24 Hour Ampere: " + (totalAmpere - totalDayAmpere));
            System.out.println("Total Revenue: " + totalRevenue + " IQD");
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeReport() {
        int totalEmployees = 0;
        int totalPartTime = 0;
        int totalFullTime = 0;
        double totalSalary = 0;

        String sql = "SELECT COUNT(*) AS total_employees, " +
                "SUM(CASE WHEN type = 'Part-time' THEN 1 ELSE 0 END) AS total_part_time, " +
                "SUM(CASE WHEN type = 'Full-time' THEN 1 ELSE 0 END) AS total_full_time, " +
                "SUM(salary) AS total_salary " +
                "FROM Employee";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalEmployees = resultSet.getInt("total_employees");
                totalPartTime = resultSet.getInt("total_part_time");
                totalFullTime = resultSet.getInt("total_full_time");
                totalSalary = resultSet.getDouble("total_salary");
            }

            System.out.println("Employee Report:");
            System.out.println("Total Employees: " + totalEmployees);
            System.out.println("Total Part-time Employees: " + totalPartTime);
            System.out.println("Total Full-time Employees: " + totalFullTime);
            System.out.println("Total Salary: " + totalSalary + " IQD");
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showFinancialReport() {
        double totalCustomerRevenue = 0;
        double totalEmployeeSalary = 0;

        // Calculate total customer revenue from the database
        String customerRevenueQuery = "SELECT SUM(CASE WHEN subscriptionType = '24-Hours' THEN ampere * 10000 ELSE ampere * 5000 END) AS total_revenue FROM customer";
        try (PreparedStatement customerStatement = connection.prepareStatement(customerRevenueQuery);
             ResultSet customerResultSet = customerStatement.executeQuery()) {
            if (customerResultSet.next()) {
                totalCustomerRevenue = customerResultSet.getDouble("total_revenue");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Calculate total employee salary from the database
        String employeeSalaryQuery = "SELECT SUM(salary) AS total_salary FROM Employee";
        try (PreparedStatement employeeStatement = connection.prepareStatement(employeeSalaryQuery);
             ResultSet employeeResultSet = employeeStatement.executeQuery()) {
            if (employeeResultSet.next()) {
                totalEmployeeSalary = employeeResultSet.getDouble("total_salary");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        double difference = totalCustomerRevenue - totalEmployeeSalary;

        System.out.println("Financial Report:");
        System.out.println("Total Customer Revenue: " + totalCustomerRevenue + " IQD");
        System.out.println("Total Employee Salary: " + totalEmployeeSalary + " IQD");
        System.out.println("Difference (Revenue - Salary): " + difference + " IQD");
    }
}
