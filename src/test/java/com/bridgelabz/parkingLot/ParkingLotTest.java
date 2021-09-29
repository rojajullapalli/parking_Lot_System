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
        boolean isParked = parkingLotSystem.park(new Object());
        Assertions.assertTrue(isParked);
    }


}
