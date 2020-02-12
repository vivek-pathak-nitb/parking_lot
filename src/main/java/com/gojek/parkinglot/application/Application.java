package com.gojek.parkinglot.application;

import com.gojek.parkinglot.commands.CommandExecutor;
import com.gojek.parkinglot.manager.ParkingManager;
import com.gojek.parkinglot.manager.ParkingSlotManager;
import com.gojek.parkinglot.models.CommandEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            runProgramViaFile(args[0]);
        } else {
            runProgramViaShell();
        }
    }

    private static void runProgramViaFile(final String filePath) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        final CommandExecutor commandExecutor = new CommandExecutor(new ParkingManager(new ParkingSlotManager()));
        while ((line = bufferedReader.readLine()) != null) {
            run(line, commandExecutor);
        }
    }

    private static void runProgramViaShell() {
        final Scanner input = new Scanner(System.in);
        final CommandExecutor commandExecutor = new CommandExecutor(new ParkingManager(new ParkingSlotManager()));
        String line = input.nextLine();
        while (!Objects.equals("exit", line)) {
            run(line, commandExecutor);
            line = input.nextLine();
        }
    }

    private static void run(final String line,
                            final CommandExecutor commandExecutor) {
        final String[] lineContent = line.split(" ");
        final CommandEnum commandEnum = CommandEnum.valueOf(lineContent[0].toUpperCase());
        commandExecutor.execute(commandEnum, Arrays.copyOfRange(lineContent, 1, lineContent.length));
    }
}
