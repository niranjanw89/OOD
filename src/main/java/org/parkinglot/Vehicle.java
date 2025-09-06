package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    public String licensePate;
    public int spotsNeeded;
    public List<ParkingSpot> parkingSpots = new ArrayList<>();
    public VehicleSize vehicleSize;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void parkInSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }

    public void cleaSpots(){
        for(int i=0;i<parkingSpots.size();i++){
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
