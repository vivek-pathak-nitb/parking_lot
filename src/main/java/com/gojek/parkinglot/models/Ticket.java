package com.gojek.parkinglot.models;

import java.util.Objects;

public class Ticket {

    private int slotNumber;

    private String registrationNumber;

    private String color;

    public Ticket(final int slotNumber,
                  final String registrationNumber,
                  final String color) {
        this.slotNumber = slotNumber;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getSlotNumber() == ticket.getSlotNumber() &&
                getRegistrationNumber().equals(ticket.getRegistrationNumber()) &&
                getColor().equals(ticket.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSlotNumber(), getRegistrationNumber(), getColor());
    }
}
