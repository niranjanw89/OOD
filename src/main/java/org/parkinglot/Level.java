package org.parkinglot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int availableSpots) {
        this.floor = floor;
        this.spots = new ParkingSpot[availableSpots];
        int largeSpots = availableSpots/4;
        int bikeSpots = availableSpots/4;
        int compactSpots = availableSpots-largeSpots-bikeSpots;
        for(int i=0;i<availableSpots;i++){
            VehicleSize vehicleSize = VehicleSize.Motorcycle;
            if(i < largeSpots){
                vehicleSize = VehicleSize.Large;
            }
            else if(i < largeSpots + compactSpots){
                vehicleSize = VehicleSize.Compact;
            }
            int row = i / SPOTS_PER_ROW;
            spots[i] = new ParkingSpot(vehicleSize,row,i,this);
        }
        this.availableSpots = availableSpots;
    }

    public int getAvailableSpots(){
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(getAvailableSpots() < vehicle.getSpotsNeeded()){
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if(spotNumber < 0){
            return false;
        }
        return parkStartingAtSpot(spotNumber,vehicle);
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.getRow()){
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if(spot.canFitVehicle(vehicle)){
                spotsFound++;
            }
            else{
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded){
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.cleaSpots();
        boolean success = true;
        for (int i = spotNumber; i < spotNumber+ vehicle.spotsNeeded; i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.spotsNeeded;
        return success;
    }

    public void spotFreed() {
        availableSpots++;
    }
}
