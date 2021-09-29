package com.bridgelabz.parkingLot;

public class ParkingLotSystem {
    private Object vechile;

    public void park(Object vechile) throws ParkingLotException {
        if (this.vechile != null)
            throw new ParkingLotException("Vechile is Already Parked");
        this.vechile = vechile;
    }

    public boolean isVechileParked(Object vechile) {
        return this.vechile.equals(vechile);
    }

    public void unPark(Object vechile) throws ParkingLotException {
        if (this.vechile == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible");
        if (this.vechile.equals(vechile))
            this.vechile = null;
    }

    public boolean isVechileUnParked(Object vechile) {
        return this.vechile == null;
    }

}
