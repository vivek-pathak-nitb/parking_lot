package com.gojek.parkinglot.commands;

import com.gojek.parkinglot.manager.ParkingManager;
import com.gojek.parkinglot.models.Car;
import com.gojek.parkinglot.models.CommandEnum;

public class CommandExecutor {

    private ParkingManager parkingManager;

    public CommandExecutor(final ParkingManager multiStoreyParkingManager) {
        this.parkingManager = multiStoreyParkingManager;
    }

    public void execute(final CommandEnum commandEnum, final String[] commandData) {
        if (commandEnum == CommandEnum.CREATE_PARKING_LOT) {
            parkingManager.createParking(1, 1, Integer.parseInt(commandData[0]));
        } else if (commandEnum == CommandEnum.PARK) {
            parkingManager.parkVehicle(new Car(commandData[0], commandData[1]));
        } else if (commandEnum == CommandEnum.LEAVE) {
            parkingManager.leaveVehicle(Integer.parseInt(commandData[0]));
        } else if (commandEnum == CommandEnum.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR) {
            parkingManager.printRegistrationNumberByColor(commandData[0]);
        } else if (commandEnum == CommandEnum.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR) {
            parkingManager.printSlotNumberByColor(commandData[0]);
        } else if (commandEnum == CommandEnum.SLOT_NUMBER_FOR_REGISTRATION_NUMBER) {
            parkingManager.printSlotNumberByRegistrationNumber(commandData[0]);
        } else if (commandEnum == CommandEnum.STATUS) {
            parkingManager.printStatus();
        }
    }
}
