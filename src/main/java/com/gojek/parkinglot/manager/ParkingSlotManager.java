package com.gojek.parkinglot.manager;

import com.gojek.parkinglot.exceptions.NoSlotsAvailableException;
import com.gojek.parkinglot.models.ParkingSlot;
import com.gojek.parkinglot.models.Ticket;
import com.gojek.parkinglot.models.Vehicle;
import com.gojek.parkinglot.templates.OutputTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkingSlotManager {

    private final List<ParkingSlot> parkingSlotList;
    private final Map<Ticket, ParkingSlot> ticketParkingSlotMap;

    public ParkingSlotManager() {
        parkingSlotList = new ArrayList<>();
        ticketParkingSlotMap = new TreeMap<>();
    }

    public ParkingSlot createSlot(final int parkingId, final int parkingSlotId) {
        final ParkingSlot parkingSlot = new ParkingSlot(parkingSlotId, true, parkingId);
        parkingSlotList.add(parkingSlot);
        return parkingSlot;
    }

    public Ticket parkVehicleInSlot(final Vehicle vehicle) throws NoSlotsAvailableException {
        final ParkingSlot parkingSlot = findFirstAvailableSlot();
        if (parkingSlot == null) {
            throw new NoSlotsAvailableException(OutputTemplate.PARKING_LOT_FULL);
        }

        parkingSlot.setIsFree(false);

        final Ticket ticket = new Ticket(parkingSlot.getId(), vehicle.getRegistrationNumber(), vehicle.getColor());
        ticketParkingSlotMap.put(ticket, parkingSlot);

        System.out.println(String.format(OutputTemplate.ALLOCATED_SLOT_NUMBER, ticket.getSlotNumber()));
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
        System.out.println(String.format(OutputTemplate.SLOT_NUMBER_IS_FREE, ticket.getSlotNumber()));
    }

    public void printRegistrationNumberByColor(final String color) {
        final StringBuilder output = new StringBuilder();
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getColor().equalsIgnoreCase(color)) {
                output.append(ticket.getRegistrationNumber()).append(", ");
            }
        }
        System.out.println(output.substring(0, output.length() - 2));
    }

    public void printSlotNumberByVehicleRegistrationNumber(final String vehicleRegNumber) {
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getRegistrationNumber().equalsIgnoreCase(vehicleRegNumber)) {
                System.out.println(ticket.getSlotNumber());
                return;
            }
        }
        System.out.println(OutputTemplate.NOT_FOUND);
    }

    public void printSlotNumberByColor(final String color) {
        final StringBuilder output = new StringBuilder();
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            if (ticket.getColor().equalsIgnoreCase(color)) {
                output.append(ticket.getSlotNumber()).append(", ");
            }
        }
        System.out.println(output.substring(0, output.length() - 2));
    }

    public void printStatus() {
        System.out.println(OutputTemplate.STATUS_HEADER);
        for (final Ticket ticket : ticketParkingSlotMap.keySet()) {
            System.out.println(String.format(OutputTemplate.STATUS_FORMAT, ticket.getSlotNumber(), ticket.getRegistrationNumber(),
                    ticket.getColor()));
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
