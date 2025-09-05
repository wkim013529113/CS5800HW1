package com.example.payables;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A freelancer paid hourly, with 1.5x overtime over 40 hours.
 */
public class Freelancer implements Payable {
    private String firstName;
    private String lastName;
    private double hourlyRate;   // >= 0
    private double hoursWorked;  // >= 0

    public Freelancer(String firstName, String lastName, double hourlyRate, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }

    // Setters with validation
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName = lastName; }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) throw new IllegalArgumentException("hourlyRate must be >= 0");
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("hoursWorked must be >= 0");
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePayment() {
        double hours = getHoursWorked();
        if (hours <= 40) return hours * hourlyRate;
        double overtime = hours - 40;
        return 40 * hourlyRate + overtime * hourlyRate * 1.5;
    }

    @Override
    public String getPayeeName() {
        return firstName + " " + lastName;
    }

    /** Prints the freelancer's full name and calculated payment. */
    public void print() {
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Freelancer: %-20s | Payment: %s (rate=%.2f, hours=%.2f)%n",
                getPayeeName(), money.format(calculatePayment()), hourlyRate, hoursWorked);
    }
}
