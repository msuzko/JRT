package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {

    public Sedan(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
