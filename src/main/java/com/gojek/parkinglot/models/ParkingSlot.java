package com.gojek.parkinglot.models;

public class ParkingSlot {

    private int id;
    private boolean isFree;
    private int parkingId;

    public ParkingSlot(final int id,
                       final boolean isFree,
                       final int parkingId) {
        this.id = id;
        this.isFree = isFree;
        this.parkingId = parkingId;
    }

    public int getId() {
        return id;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }
}
