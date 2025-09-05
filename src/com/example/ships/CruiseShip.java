package com.example.ships;

/** Cruise ship with a maximum passenger count. */
public class CruiseShip extends Ship {
    private int maxPassengers;  // maximum number of passengers

    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        setMaxPassengers(maxPassengers);
    }

    // Getter / Setter
    public int getMaxPassengers() { return maxPassengers; }

    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 0)
            throw new IllegalArgumentException("maxPassengers must be >= 0");
        this.maxPassengers = maxPassengers;
    }

    /** Overrides base print: show name and max passengers. */
    @Override
    public void print() {
        System.out.printf("Cruise Ship: %s (Max passengers: %d)%n",
                getName(), maxPassengers);
    }
}
