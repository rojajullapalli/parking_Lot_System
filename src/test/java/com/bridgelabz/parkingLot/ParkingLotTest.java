package com.bridgelabz.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    Object vechile;
    ParkingLotSystem parkingLotSystem;

    @BeforeEach
    void setUp() {
        vechile = new Object();
        parkingLotSystem = new ParkingLotSystem();
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
            boolean park = parkingLotSystem.isVechileParked(vechile);
            parkingLotSystem.unPark(vechile);
            boolean unPark = parkingLotSystem.isVechileUnParked(vechile);
            Assertions.assertEquals(park, unPark);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenAlreadyParked_Should_ReturnFalse() {
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(vechile);
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Vechile is Already Parked", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenNotParked_ShouldNotBeUnparked() {
        try {
            parkingLotSystem.unPark(new Object());
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Vechile To Be Parked To Unpark.Unpark Is Not Possible", e.getMessage());
            e.printStackTrace();
        }
    }

}

