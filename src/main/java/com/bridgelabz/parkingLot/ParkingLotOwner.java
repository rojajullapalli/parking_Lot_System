package com.bridgelabz.parkingLot;

public class ParkingLotOwner implements ParkingLotObserver {
    private boolean isFullCapacity;

    public void capacityIsFull() {
        isFullCapacity = true;
    }
    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}
