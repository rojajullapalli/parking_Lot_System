package com.bridgelabz.parkingLot;

public class ParkingLotException extends Exception {
    ExceptionName type;

    public ParkingLotException(String message, ExceptionName type) {
        super(message);
        this.type = type;
    }

    enum ExceptionName {CANNOT_PARK}
}
