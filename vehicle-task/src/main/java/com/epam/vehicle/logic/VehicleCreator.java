package com.epam.vehicle.logic;

import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Train;
import com.epam.vehicle.domain.Vehicle;

import java.util.Objects;

public class VehicleCreator {

    public Vehicle createVehicle(String input){
        if (nullOrIsBlank(input)) {
            throw new IllegalArgumentException("Input string is null");
        }
        String[] splittedString = input.split(",");

        checkTheFirstItemInArrayIsValid(splittedString);

        checkIfValuesAreEnough(splittedString);

        return returnWithProperVehicle(splittedString);

    }
    private Vehicle returnWithProperVehicle(String[] splittedString) {
        if (checkIfCar(splittedString)) {
            return new Car(splittedString[1], splittedString[2], Long.parseLong(splittedString[3]), Integer.parseInt(splittedString[4]));
        } else if (checkIfTrain(splittedString)) {
            return new Train(splittedString[1], splittedString[2], Long.parseLong(splittedString[3]));
        } else
            throw new IllegalArgumentException("Unknown vehicle types.");
    }

    private boolean checkIfTrain(String[] splittedString) {
        return Objects.equals(splittedString[0], "Train") && splittedString.length == 4;
    }

    private boolean checkIfCar(String[] splittedString) {
        return Objects.equals(splittedString[0], "Car") && splittedString.length == 5;
    }

    private void checkIfValuesAreEnough(String[] splittedString) {
        if ((Objects.equals(splittedString[0], "Car") && splittedString.length != 5) ||
                (Objects.equals(splittedString[0], "Train") && splittedString.length != 4)) {
            throw new IllegalArgumentException("Not enough values.");
        }
    }

    private void checkTheFirstItemInArrayIsValid(String[] splittedString) {
        if ((!Objects.equals(splittedString[0], "Car")) && (!splittedString[0].equals("Train"))) {
            throw new IllegalArgumentException("Unknown vehicle types.");
        }
    }

    private boolean nullOrIsBlank(String inputString) {
        return inputString == null || inputString.isBlank();
    }
}
