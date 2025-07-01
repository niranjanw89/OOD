package org.example;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        spotsNeeded = 1;
        vehicleSize = VehicleSize.Motorcycle;
    }


    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    @Override
    public void print() {
        System.out.println("M");
    }
}
