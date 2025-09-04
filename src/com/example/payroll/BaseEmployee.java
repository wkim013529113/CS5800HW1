package com.example.payroll;

// BaseEmployee.java
public class BaseEmployee extends Employee {
    private double baseSalaryAnnual;

    public BaseEmployee(String firstName, String lastName, String ssn, double baseSalaryAnnual) {
        super(firstName, lastName, ssn);
        setBaseSalaryAnnual(baseSalaryAnnual);
    }

    public double getBaseSalaryAnnual() { return baseSalaryAnnual; }

    public void setBaseSalaryAnnual(double baseSalaryAnnual) {
        if (baseSalaryAnnual < 0) throw new IllegalArgumentException("Base salary must be >= 0");
        this.baseSalaryAnnual = baseSalaryAnnual;
    }

    /** For weekly comparison in this demo. */
    public double getBaseSalaryWeekly() { return baseSalaryAnnual / 52.0; }

    @Override
    public double earnings() {
        return getBaseSalaryWeekly();
    }

    @Override
    public String toString() {
        return String.format("BaseEmployee: %s, baseSalaryAnnual=$%,.2f (~$%,.2f/week)",
                super.toString(), baseSalaryAnnual, earnings());
    }
}
