package com.example.payroll;

public class HourlyEmployee extends Employee {
    private double wage;  // hourly
    private double hours; // hours worked in the week

    public HourlyEmployee(String firstName, String lastName, String ssn,
                          double wage, double hours) {
        super(firstName, lastName, ssn);
        setWage(wage);
        setHours(hours);
    }

    public double getWage() { return wage; }
    public double getHours() { return hours; }

    public void setWage(double wage) {
        if (wage < 0) throw new IllegalArgumentException("Wage must be >= 0");
        this.wage = wage;
    }

    public void setHours(double hours) {
        if (hours < 0 || hours > 168) throw new IllegalArgumentException("Hours must be 0..168");
        this.hours = hours;
    }

    @Override
    public double earnings() {
        // Overtime (over 40 hours) paid at 1.5x
        if (hours <= 40) return wage * hours;
        double overtime = hours - 40;
        return wage * 40 + wage * 1.5 * overtime;
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee: %s, wage=$%,.2f, hours=%.2f",
                super.toString(), wage, hours);
    }
}
