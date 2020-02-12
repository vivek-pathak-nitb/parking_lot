package com.gojek.parkinglot.commands;

import com.gojek.parkinglot.manager.ParkingManager;
import com.gojek.parkinglot.models.Car;
import com.gojek.parkinglot.models.CommandEnum;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CommandExecutorTest {

    private static final String[] DUMMY_DATA = {"1", "2"};

    private ParkingManager mockParkingManager;
    private CommandExecutor commandExecutor;


    @Before
    public void setup() {
        mockParkingManager = mock(ParkingManager.class);
        commandExecutor = new CommandExecutor(mockParkingManager);
    }

    @Test
    public void testExecute() {
        // Executing various commands
        commandExecutor.execute(CommandEnum.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.LEAVE, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.PARK, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.CREATE_PARKING_LOT, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, DUMMY_DATA);
        commandExecutor.execute(CommandEnum.STATUS, DUMMY_DATA);

        // verifying mocks
        verify(mockParkingManager, times(1)).printRegistrationNumberByColor(anyString());
        verify(mockParkingManager, times(1)).printSlotNumberByColor(anyString());
        verify(mockParkingManager, times(1)).printSlotNumberByRegistrationNumber(anyString());
        verify(mockParkingManager, times(1)).printStatus();
        verify(mockParkingManager, times(1)).parkVehicle(any(Car.class));
        verify(mockParkingManager, times(1)).leaveVehicle(anyInt());
    }
}
