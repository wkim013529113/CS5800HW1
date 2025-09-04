package com.example.payroll;// EmployeeDriver.java  (aka Main.java)

// A driver program that creates sample employees and prints weekly earnings.
import java.util.*;

public class EmployeeDriver {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();

        staff.add(new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00));
        staff.add(new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32));
        staff.add(new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47));
        staff.add(new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50_000.00));
        staff.add(new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00));
        staff.add(new BaseEmployee("Mike", "Davenport", "666-66-6666", 95_000.00));
        staff.add(new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40_000.00));

        System.out.println("=== Employee Roster & Weekly Earnings ===");
        for (Employee e : staff) {
            System.out.printf("%s%n  -> weekly earnings: $%,.2f%n%n", e, e.earnings());
        }
    }
}
