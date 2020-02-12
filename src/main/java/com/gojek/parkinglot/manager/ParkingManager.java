package com.gojek.parkinglot.manager;

import com.gojek.parkinglot.exceptions.NoSlotsAvailableException;
import com.gojek.parkinglot.models.Parking;
import com.gojek.parkinglot.models.ParkingSlot;
import com.gojek.parkinglot.models.Ticket;
import com.gojek.parkinglot.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    private final ParkingSlotManager parkingSlotManager;
    private final List<Parking> parkingList;

    public ParkingManager(final ParkingSlotManager parkingSlotManager) {
        this.parkingSlotManager = parkingSlotManager;
        parkingList = new ArrayList<>();
    }

    public Parking createParking(final int level, final int id, final int numberOfSlots) {
        final List<ParkingSlot> parkingSlots = new ArrayList<>();
        for (int i = 1; i <= numberOfSlots; i++) {
            parkingSlots.add(parkingSlotManager.createSlot(id, i));
        }

        final Parking parking = new Parking(id, level, parkingSlots);
        parkingList.add(parking);

        System.out.println("Created a parking lot with " + numberOfSlots + " slots");

        return parking;
    }

    public Ticket parkVehicle(final Vehicle vehicle) {
        try {
            return parkingSlotManager.parkVehicleInSlot(vehicle);
        } catch (NoSlotsAvailableException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void leaveVehicle(final int slotNumber) {
        parkingSlotManager.leaveSlot(slotNumber);
    }

    public void printRegistrationNumberByColor(final String color) {
        parkingSlotManager.printRegistrationNumberByColor(color);
    }

    public void printSlotNumberByColor(final String color) {
        parkingSlotManager.printSlotNumberByColor(color);
    }

    public void printSlotNumberByRegistrationNumber(final String regNumber) {
        parkingSlotManager.printSlotNumberByVehicleRegistrationNumber(regNumber);
    }

    public void printStatus() {
        parkingSlotManager.printStatus();
    }
}
