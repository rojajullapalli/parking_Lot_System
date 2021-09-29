package com.bridgelabz.parkingLot;

public class ParkingLotSystem {
    private Object vechile;


    public void park(Object vechile) throws ParkingLotException {
        if(this.vechile != null)
            throw new ParkingLotException("Parking Lot Is Full");
        this.vechile = vechile;
    }

    public boolean isVechileParked(Object vechile) {
        if(this.vechile.equals(vechile))
            return true;
        return false;
    }

    public void unPark(Object vechile) throws ParkingLotException {
        if(this.vechile == null)
            throw new ParkingLotException("Vechile To Be Parked To Unpark.Unpark Is Not Possible");
        if(this.vechile.equals(vechile))
            this.vechile = null;
    }

    public boolean isVechileUnParked(Object vechile) {
        if(this.vechile == null)
            return true;
        return false;
    }
}
