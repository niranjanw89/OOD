package org.parkinglot;

public class Car extends Vehicle{

    public Car() {
        spotsNeeded = 1;
        vehicleSize = VehicleSize.Compact;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.println("C");
    }
}
