package com.bridgelabz.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    ParkingLotOwner owner;
    Object vechile;
    ParkingLotSystem parkingLotSystem;
    AirportSecurity airportSecurity;

    @BeforeEach
    void setUp() {
        vechile = new Object();
        parkingLotSystem = new ParkingLotSystem(1);
        owner = new ParkingLotOwner();
        airportSecurity = new AirportSecurity();
    }

    @Test
    void givenAVechicle_WhenParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vechile);
            boolean isparked = parkingLotSystem.isVechileParked(vechile);
            Assertions.assertTrue(isparked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenUnparked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vechile);
            boolean isUnparked = parkingLotSystem.unPark(vechile);
            Assertions.assertTrue(isUnparked);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenAlreadyParked_Should_ReturnFalse() throws ParkingLotException {
        parkingLotSystem.park(vechile);
        try {
            parkingLotSystem.park(vechile);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenNotParked_ShouldNotBeUnparked() {
        try {
            parkingLotSystem.unPark(vechile);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Vechile To Be Parked To Unpark.Unpark Is Not Possible", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void given_Car_WhenParkingLotFull_ShouldInformOwner() {
        parkingLotSystem.registerParkingLotObserver(owner);
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = owner.isCapacityFull();
            Assertions.assertTrue(capacityFull);

        }
    }

    @Test
    void givenCapacityIs2_ShouldBeAbleToParkTwoVechiles() throws ParkingLotException {
        Object vechile2 = new Object();
        parkingLotSystem.setCapcity(2);
        parkingLotSystem.registerParkingLotObserver(owner);
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(vechile2);
            boolean isparked1 = parkingLotSystem.isVechileParked(vechile);
            boolean isParked2 = parkingLotSystem.isVechileParked(vechile2);
            Assertions.assertTrue(isparked1 && isParked2);
    }

    @Test
    void given_Car_WhenParkingLotFull_ShouldInformAirportSecueity(){
        parkingLotSystem.registerParkingLotObserver(airportSecurity);
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            boolean capacityFull = airportSecurity.isCapacityFull();
            Assertions.assertTrue(capacityFull);
        }
    }

    @Test
    void given_Car_WhenParkingNotLotFull_ShouldNotInformAirportSecueity(){
        parkingLotSystem.registerParkingLotObserver(airportSecurity);
        try {
            parkingLotSystem.park(vechile);
        } catch (ParkingLotException e) {
            boolean capacityFull = airportSecurity.isCapacityFull();
            Assertions.assertFalse(capacityFull);
        }
    }

    @Test
    void givenWhenParkingLotSpaceIsAvailableAfterFull_ShouldReturnTrue() throws ParkingLotException {
        Object vechile2 = new Object();
        parkingLotSystem.registerParkingLotObserver(owner);
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(vechile2);
        } catch (ParkingLotException e) {
            parkingLotSystem.unPark(vechile);
            boolean capacityFull = owner.isCapacityFull();
            Assertions.assertFalse(capacityFull);
        }
    }
}

