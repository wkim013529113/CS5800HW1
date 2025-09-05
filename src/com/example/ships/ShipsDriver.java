package com.example.ships;

/**
 * Demonstrates polymorphism:
 * - Creates a static array of Ship (size 3) with one Ship, one CruiseShip, and one CargoShip.
 * - Loops and calls print() on each element.
 */
public class ShipsDriver {
    public static void main(String[] args) {
        // Static array of size 3
        Ship[] fleet = new Ship[3];

        // Dynamically instantiate one of each type
        fleet[0] = new Ship("SS Classic", "1998");
        fleet[1] = new CruiseShip("Ocean Star", "2010", 3200);
        fleet[2] = new CargoShip("Atlas Trader", "2005", 45000);

        // Polymorphic calls: each object's overridden print() runs
        for (Ship s : fleet) {
            s.print();
        }
    }
}
