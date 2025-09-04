package com.example.payroll;// EmployeeTableDriver.java
// Driver that prints the sample data in a table, plus weekly pay.

import java.text.NumberFormat;
import java.util.*;

public class EmployeeTableDriver {

    private static final NumberFormat MONEY = NumberFormat.getCurrencyInstance(Locale.US);
    private static final NumberFormat PCT = NumberFormat.getPercentInstance(Locale.US);
    static {
        PCT.setMinimumFractionDigits(0);
        PCT.setMaximumFractionDigits(2);
    }

    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();

        // Sample data from your table
        staff.add(new SalariedEmployee("Joe",      "Jones",     "111-11-1111", 2500.00));
        staff.add(new HourlyEmployee  ("Stephanie","Smith",     "222-22-2222",   25.00, 32));
        staff.add(new HourlyEmployee  ("Mary",     "Quinn",     "333-33-3333",   19.00, 47)); // overtime
        staff.add(new CommissionEmployee("Nicole","Dior",       "444-44-4444",    0.15, 50_000.00));
        staff.add(new SalariedEmployee("Renwa",    "Chanel",    "555-55-5555", 1700.00));
        staff.add(new BaseEmployee    ("Mike",     "Davenport", "666-66-6666", 95_000.00));  // annual base
        staff.add(new CommissionEmployee("Mahnaz", "Vaziri",    "777-77-7777",    0.22, 40_000.00));

        // Build rows
        String[] headers = {
                "First name","Last name","Social Sec #","Weekly Salary","Wage",
                "Hours worked","Com rate","Gross sales","Base salary","Weekly pay"
        };
        List<String[]> rows = new ArrayList<>();
        for (Employee e : staff) {
            String weeklySalary = "";
            String wage = "";
            String hours = "";
            String comRate = "";
            String grossSales = "";
            String baseSalary = "";

            if (e instanceof SalariedEmployee s) {
                weeklySalary = MONEY.format(s.getWeeklySalary());
            }
            if (e instanceof HourlyEmployee h) {
                wage  = MONEY.format(h.getWage());
                hours = String.format("%.0f", h.getHours());
            }
            if (e instanceof CommissionEmployee c) {
                comRate    = PCT.format(c.getCommissionRate());
                grossSales = MONEY.format(c.getGrossSales());
            }
            if (e instanceof BaseEmployee b) {
                baseSalary = MONEY.format(b.getBaseSalaryAnnual());
            }

            String weeklyPay = MONEY.format(e.earnings());

            rows.add(new String[] {
                    e.getFirstName(),
                    e.getLastName(),
                    e.getSocialSecurityNumber(),
                    weeklySalary,
                    wage,
                    hours,
                    comRate,
                    grossSales,
                    baseSalary,
                    weeklyPay
            });
        }

        printTable(headers, rows);
    }

    // ----- simple ASCII table printer -----
    private static void printTable(String[] headers, List<String[]> rows) {
        int cols = headers.length;
        int[] widths = new int[cols];

        // compute max width per column
        for (int i = 0; i < cols; i++) {
            widths[i] = headers[i].length();
        }
        for (String[] row : rows) {
            for (int i = 0; i < cols; i++) {
                String cell = (i < row.length && row[i] != null) ? row[i] : "";
                widths[i] = Math.max(widths[i], cell.length());
            }
        }

        String sep = buildSep(widths);
        System.out.println(sep);
        System.out.println(rowToLine(headers, widths));
        System.out.println(sep);
        for (String[] r : rows) {
            System.out.println(rowToLine(r, widths));
        }
        System.out.println(sep);
    }

    private static String buildSep(int[] widths) {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (int w : widths) {
            sb.append("-".repeat(w + 2)).append('+');
        }
        return sb.toString();
    }

    private static String rowToLine(String[] cells, int[] widths) {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        for (int i = 0; i < widths.length; i++) {
            String cell = (i < cells.length && cells[i] != null) ? cells[i] : "";
            sb.append(' ').append(padRight(cell, widths[i])).append(' ').append('|');
        }
        return sb.toString();
    }

    private static String padRight(String s, int w) {
        if (s.length() >= w) return s;
        return s + " ".repeat(w - s.length());
    }
}
