package com.gojek.parkinglot.models;

import java.util.List;

public class Parking {

    private int id;
    private int level;
    private List<ParkingSlot> parkingSlotList;

    public Parking(final int id,
                   final int level,
                   final List<ParkingSlot> parkingSlotList) {
        this.id = id;
        this.level = level;
        this.parkingSlotList = parkingSlotList;
    }

    public int getLevel() {
        return level;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }
}
