package com.bridgelabz.parkingLot;

public class ParkingLotException extends Exception {
    enum ExceptionName {CANNOT_PARK}
    ExceptionName type;
    public ParkingLotException(String message, ExceptionName type) {
        super(message);
        this.type = type;
    }
}
