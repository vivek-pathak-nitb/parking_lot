package com.gojek.parkinglot.manager;

import com.gojek.parkinglot.models.Car;
import com.gojek.parkinglot.models.Parking;
import com.gojek.parkinglot.models.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingManagerTest {

    private ParkingManager underTest;

    @Before
    public void setup() {
        underTest = new ParkingManager(new ParkingSlotManager());
    }

    @Test
    public void createParking() {
        // execute
        final Parking parking = underTest.createParking(1, 2, 3);

        //verify
        assertEquals(2, parking.getId());
        assertEquals(1, parking.getLevel());
        assertEquals(3, parking.getParkingSlotList().size());
    }

    @Test
    public void parkVehicle() {
        // set up
        underTest.createParking(1, 2, 3);
        final Car car = new Car("123", "White");

        // execute
        final Ticket ticket = underTest.parkVehicle(car);
        // verify
        assertEquals(1, ticket.getSlotNumber());
        assertEquals("White", ticket.getColor());
        assertEquals("123", ticket.getRegistrationNumber());
    }

    @Test
    public void leaveVehicle() {
        // execute
        underTest.leaveVehicle(1);
    }
}
