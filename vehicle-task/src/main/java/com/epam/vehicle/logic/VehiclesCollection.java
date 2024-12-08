package com.epam.vehicle.logic;

import com.epam.vehicle.domain.Car;
import com.epam.vehicle.domain.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class VehiclesCollection {
    List<Vehicle> vehicleList;

    public VehiclesCollection() {
        this.vehicleList = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle can not be null");
        }
        vehicleList.add(vehicle);
    }
    public Vehicle getVehicle(String make, String model) {
        if (make == null || model == null || make.isBlank() || model.isBlank()) {
            throw new NoSuchElementException();
        }
        return vehicleList.stream().filter(vehicle -> Objects.equals(vehicle.getMake(), make) && Objects.equals(vehicle.getModel(), model))
                .findAny().orElseThrow(NoSuchElementException::new);
    }
    public List<Car> getCarsWhereModelYearIsBeforeSortedBySpeed(int modelYear) {

        return vehicleList.stream().filter(vehicle -> vehicle instanceof Car)
                .map(vehicle -> (Car) vehicle)
                .toList()
                .stream().filter(car -> car.getModelYear() < modelYear)
                .sorted(Comparator.comparing(Vehicle::getSpeed))
                .collect(Collectors.toList());
    }

}
