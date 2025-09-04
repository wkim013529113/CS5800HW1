package com.example.payroll;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
        super(firstName, lastName, ssn);
        setWeeklySalary(weeklySalary);
    }

    public double getWeeklySalary() { return weeklySalary; }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0) throw new IllegalArgumentException("Weekly salary must be >= 0");
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("SalariedEmployee: %s, weeklySalary=$%,.2f",
                super.toString(), weeklySalary);
    }
}
