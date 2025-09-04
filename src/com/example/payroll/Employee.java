package com.example.payroll;

// Base abstract class: common identity for all employees
public abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber; // format ###-##-####

    protected Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Accessors (getters)
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getSocialSecurityNumber() { return socialSecurityNumber; }

    // Mutators (setters)
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName = lastName; }
    public void setSocialSecurityNumber(String ssn) { this.socialSecurityNumber = ssn; }

    // Polymorphic pay calculation (weekly for this demo)
    public abstract double earnings();

    @Override
    public String toString() {
        return String.format("%s %s (SSN: %s)", firstName, lastName, socialSecurityNumber);
    }
}
