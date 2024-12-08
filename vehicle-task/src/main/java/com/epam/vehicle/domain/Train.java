package com.epam.vehicle.domain;

public class Train extends Vehicle{

    public Train(String make, String model, long speed) {
        super(make, model, speed);
    }

    @Override
    public String toString() {
        return "Train{" +
                "make=" + getMake() +","+
                "model=" + getModel() +","+
                " speed=" + getSpeed() +","+
                '}';
    }
    @Override
    public long move(double duration) {
        return Math.round(((double) getSpeed() / 2 * 0.2) + (getSpeed() * (duration - 0.2)));
    }
}
