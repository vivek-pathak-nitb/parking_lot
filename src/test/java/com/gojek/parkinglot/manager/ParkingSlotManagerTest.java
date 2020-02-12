package com.gojek.parkinglot.manager;

import com.gojek.parkinglot.exceptions.NoSlotsAvailableException;
import com.gojek.parkinglot.models.Car;
import com.gojek.parkinglot.models.ParkingSlot;
import com.gojek.parkinglot.models.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingSlotManagerTest {

    private ParkingSlotManager underTest;

    @Before
    public void setup() {
        underTest = new ParkingSlotManager();
    }

    @Test
    public void createSlot() {
        // execute
        final ParkingSlot parkingSlot = underTest.createSlot(1, 2);

        // verify
        assertEquals(1, parkingSlot.getParkingId());
        assertEquals(2, parkingSlot.getId());
    }

    @Test
    public void parkVehicleInSlot() throws NoSlotsAvailableException {
        // setup
        underTest.createSlot(1, 2);
        final Car car = new Car("123", "White");

        // execute
        final Ticket ticket = underTest.parkVehicleInSlot(car);

        // verify
        assertEquals(2, ticket.getSlotNumber());
        assertEquals("White", ticket.getColor());
        assertEquals("123", ticket.getRegistrationNumber());
    }

    @Test
    public void leaveSlot() {
        // execute
        underTest.leaveSlot(2);
    }
}
