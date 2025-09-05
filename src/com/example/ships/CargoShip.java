package com.example.ships;

/** Cargo ship with capacity in tonnage. */
public class CargoShip extends Ship {
    private int cargoCapacityTonnage; // capacity in tons

    public CargoShip(String name, String yearBuilt, int cargoCapacityTonnage) {
        super(name, yearBuilt);
        setCargoCapacityTonnage(cargoCapacityTonnage);
    }

    // Getter / Setter
    public int getCargoCapacityTonnage() { return cargoCapacityTonnage; }

    public void setCargoCapacityTonnage(int cargoCapacityTonnage) {
        if (cargoCapacityTonnage < 0)
            throw new IllegalArgumentException("cargoCapacityTonnage must be >= 0");
        this.cargoCapacityTonnage = cargoCapacityTonnage;
    }

    /** Overrides base print: show name and cargo capacity. */
    @Override
    public void print() {
        System.out.printf("Cargo Ship: %s (Capacity: %d tons)%n",
                getName(), cargoCapacityTonnage);
    }
}
