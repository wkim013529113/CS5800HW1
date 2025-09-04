package com.example.payroll;

// CommissionEmployee.java
public class CommissionEmployee extends Employee {
    private double commissionRate; // 0..1
    private double grossSales;     // for the pay period (week for this demo)

    public CommissionEmployee(String firstName, String lastName, String ssn,
                              double commissionRate, double grossSales) {
        super(firstName, lastName, ssn);
        setCommissionRate(commissionRate);
        setGrossSales(grossSales);
    }

    public double getCommissionRate() { return commissionRate; }
    public double getGrossSales() { return grossSales; }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0 || commissionRate > 1)
            throw new IllegalArgumentException("Commission rate must be 0..1");
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0) throw new IllegalArgumentException("Gross sales must be >= 0");
        this.grossSales = grossSales;
    }

    @Override
    public double earnings() {
        return commissionRate * grossSales;
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee: %s, commission=%.2f%%, grossSales=$%,.2f",
                super.toString(), commissionRate * 100.0, grossSales);
    }
}
