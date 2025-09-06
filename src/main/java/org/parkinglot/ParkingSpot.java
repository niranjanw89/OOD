package org.parkinglot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private  int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize spotSize, int row, int spotNumber, Level level) {
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }


    public VehicleSize getSize() {
        return spotSize;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    public boolean park(Vehicle vehicle){
        if(!canFitVehicle(vehicle)){
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle(){
        level.spotFreed();
        this.vehicle = null;
    }

    public void print(){
        if(this.vehicle == null){
            if(spotSize == VehicleSize.Large){
                System.out.println("L");
            }
            else if(spotSize == VehicleSize.Compact){
                System.out.println("C");
            }
            else if(spotSize == VehicleSize.Motorcycle){
                System.out.println("M");
            }
        }
        else{
            vehicle.print();
        }
    }
}
