package com.gojek.parkinglot.manager;

import com.gojek.parkinglot.exceptions.NoSlotsAvailableException;
import com.gojek.parkinglot.models.ParkingSlot;
import com.gojek.parkinglot.models.Ticket;
import com.gojek.parkinglot.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSlotManager {

    private final List<ParkingSlot> parkingSlotList;
    private final Map<Ticket, ParkingSlot> ticketParkingSlotMap;

    public ParkingSlotManager() {
        parkingSlotList = new ArrayList<>();
        ticketParkingSlotMap = new HashMap<>();
    }

    public ParkingSlot createSlot(final int parkingId, final int parkingSlotId) {
        final ParkingSlot parkingSlot = new ParkingSlot(parkingSlotId, true, parkingId);
        parkingSlotList.add(parkingSlot);
        return parkingSlot;
    }

    public Ticket parkVehicleInSlot(final Vehicle vehicle) throws NoSlotsAvailableException {
        final ParkingSlot parkingSlot = findFirstAvailableSlot();
        if (parkingSlot == null) {
            throw new NoSlotsAvailableException("Sorry all slots are full.");
        }

        parkingSlot.setIsFree(false);

        final Ticket ticket = new Ticket(parkingSlot.getId(), vehicle.getRegistrationNumber(), vehicle.getColor());
        ticketParkingSlotMap.put(ticket, parkingSlot);

        System.out.println("Allocated slot number : " + ticket.getSlotNumber());
        return ticket;
    }

    public void leaveSlot(final int slotNumber) {
        final Ticket ticket = getTicketBySlotNumber(slotNumber);

        if (ticket == null) {
            return;
        }

        final ParkingSlot parkingSlot = ticketParkingSlotMap.get(ticket);
        parkingSlot.setIsFree(true);
        ticketParkingSlotMap.remove(ticket);
        System.out.println("Slot number " + ticket.getSlotNumber() + " is free.");
    }

    public void printRegistrationNumberByColor(final String color) {
        System.out.println();

        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getColor().equalsIgnoreCase(color)) {
                System.out.print(ticket.getRegistrationNumber());
            }
        }
    }

    public void printSlotNumberByVehicleRegistrationNumber(final String vehicleRegNumber) {
        System.out.println();

        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getRegistrationNumber().equalsIgnoreCase(vehicleRegNumber)) {
                System.out.print(ticket.getSlotNumber());
                return;
            }
        }

        System.out.println("Not found.");
    }

    public void printSlotNumberByColor(final String color) {
        System.out.println();

        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getColor().equalsIgnoreCase(color)) {
                System.out.print(ticket.getSlotNumber());
            }
        }
    }

    public void printStatus() {
        System.out.println("Slot No.       Registration No.        Colour ");
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            System.out.println(ticket.getSlotNumber() + "       " + ticket.getRegistrationNumber() + "       " + ticket.getColor());
        }
    }

    private Ticket getTicketBySlotNumber(final int slotNumber) {
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getSlotNumber() == slotNumber) {
                return ticket;
            }
        }
        return null;
    }

    private ParkingSlot findFirstAvailableSlot() {
        for (final ParkingSlot parkingSlot : parkingSlotList) {
            if (parkingSlot.isFree()) {
                return parkingSlot;
            }
        }
        return null;
    }
}
