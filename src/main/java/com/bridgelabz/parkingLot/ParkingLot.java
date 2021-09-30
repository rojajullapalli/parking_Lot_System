package com.bridgelabz.parkingLot;

public class ParkingLot {
    private final Person person;
    private boolean isFullCapacity;

    public ParkingLot(Person person) {
        this.person = person;
    }

    public void capacityIsFull() {
        isFullCapacity = true;
    }

    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }

    enum Person {OWNER, SEQURITY}
}
