package com.example.ships;

/** Base class for all ships. */
public class Ship {
    private String name;       // ship name
    private String yearBuilt;  // year built (kept as String per spec)

    public Ship(String name, String yearBuilt) {
        setName(name);
        setYearBuilt(yearBuilt);
    }

    // Accessors (getters)
    public String getName() { return name; }
    public String getYearBuilt() { return yearBuilt; }

    // Mutators (setters)
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be blank");
        this.name = name;
    }

    public void setYearBuilt(String yearBuilt) {
        if (yearBuilt == null || yearBuilt.isBlank())
            throw new IllegalArgumentException("yearBuilt cannot be blank");
        this.yearBuilt = yearBuilt;
    }

    /** Prints the ship name and year it was built. */
    public void print() {
        System.out.printf("Ship: %s (Built: %s)%n", name, yearBuilt);
    }
}
