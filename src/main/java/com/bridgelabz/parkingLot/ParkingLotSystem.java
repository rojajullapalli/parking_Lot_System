package com.bridgelabz.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystem {
    private int actualCapacity;
    private List vechiles;
    private List<ParkingLotObserver> observers;

    public ParkingLotSystem(int capacity) {
        this.observers = new ArrayList<>();
        this.vechiles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void registerParkingLotObserver(ParkingLotObserver observer) {
        this.observers.add(observer);
    }


    public void setCapcity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vechile) throws ParkingLotException {
        if(isVechileParked(vechile))
            throw new ParkingLotException("Cannot Park Already Vechile Parked", ParkingLotException.ExceptionName.CANNOT_PARK);
        if (this.vechiles.size() == actualCapacity) {
            for (ParkingLotObserver observer:observers) {
                observer.capacityIsFull();
            }
            throw new ParkingLotException("Cannot Park Parking Lot Already Is Full", ParkingLotException.ExceptionName.CANNOT_PARK);
        }
        this.vechiles.add(vechile);
    }


    public boolean isVechileParked(Object vechile) {
        if(this.vechiles.contains(vechile))
            return true;
        return false;
    }

    public boolean unPark(Object vechile) throws ParkingLotException {
        if (vechile == null)
            return false;
        if (this.vechiles.contains(vechile)){
            this.vechiles.remove(vechile);
            for (ParkingLotObserver observer:observers) {
                observer.capacityIsAvailable();
            }
            return true;
        }
        throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible", ParkingLotException.ExceptionName.CANNOT_PARK);
    }
}
