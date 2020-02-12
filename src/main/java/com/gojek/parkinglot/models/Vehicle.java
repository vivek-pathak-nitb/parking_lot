package com.gojek.parkinglot.models;

public abstract class Vehicle {

    protected String registrationNumber;
    protected String color;

    public Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    protected String getRegistrationNumber() {
        return registrationNumber;
    }

    protected String getColor() {
        return color;
    }

    protected void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    protected void setColor(String color) {
        this.color = color;
    }
}
