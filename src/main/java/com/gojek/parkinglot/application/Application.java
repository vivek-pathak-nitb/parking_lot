package com.gojek.parkinglot.application;

import com.gojek.parkinglot.commands.CommandExecutor;
import com.gojek.parkinglot.exceptions.NoSlotsAvailableException;
import com.gojek.parkinglot.manager.ParkingManager;
import com.gojek.parkinglot.manager.ParkingSlotManager;
import com.gojek.parkinglot.models.CommandEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) throws IOException, NoSlotsAvailableException {
        run(args[0]);
    }

    private static void run(final String filePath) throws IOException, NoSlotsAvailableException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        final CommandExecutor commandExecutor = new CommandExecutor(new ParkingManager(new ParkingSlotManager()));
        while ((line = bufferedReader.readLine()) != null) {
            final String[] lineContent = line.split(" ");
            final CommandEnum commandEnum = CommandEnum.valueOf(lineContent[0].toUpperCase());
            commandExecutor.execute(commandEnum, Arrays.copyOfRange(lineContent, 1, lineContent.length));
        }
    }
}
