package com.example.courses;

/** Represents an instructor. */
public class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    public Instructor(String firstName, String lastName, String officeNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setOfficeNumber(officeNumber);
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getOfficeNumber() { return officeNumber; }

    // Setters (with basic validation)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("firstName cannot be blank");
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("lastName cannot be blank");
        this.lastName = lastName;
    }
    public void setOfficeNumber(String officeNumber) {
        if (officeNumber == null || officeNumber.isBlank())
            throw new IllegalArgumentException("officeNumber cannot be blank");
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Office " + officeNumber + ")";
    }
}
