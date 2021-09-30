package com.bridgelabz.parkingLot;

public class ParkingLotSystem {
    private int actualCapacity;
    private int currentCapacity;
    private Object vechile;

    public ParkingLotSystem(int capacity) {
        this.actualCapacity = capacity;
        this.currentCapacity = 0;
    }

    public void parking(Object vechile) throws ParkingLotException {
        if(this.vechile != null)
            throw new ParkingLotException("Vechile Already Parked",ParkingLotException.ExceptionName.CANNOT_PARK);
        this.vechile = vechile;
    }

    public void park(Object vechile) throws ParkingLotException {
        if (this.currentCapacity == actualCapacity) {
            capacityIsFull();
            throw new ParkingLotException("Cannot Park Parking Lot Already Is Full",ParkingLotException.ExceptionName.CANNOT_PARK);
        }
        this.currentCapacity++;
        this.vechile = vechile;
    }

    public boolean capacityIsFull() {
        return true;
    }

    public boolean isFreespace() throws ParkingLotException {
        throw new ParkingLotException("Parking Lot Is Free You Can Park", ParkingLotException.ExceptionName.CANNOT_PARK);
    }

    public boolean isVechileParked(Object vechile) {
        return this.vechile.equals(vechile);
    }

    public void unPark(Object vechile) throws ParkingLotException {
        if (this.vechile == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible", ParkingLotException.ExceptionName.CANNOT_PARK);
        if (this.vechile.equals(vechile))
            this.vechile = null;
    }

    public boolean isVechileUnParked(Object vechile) {
        return this.vechile == null;
    }

}
