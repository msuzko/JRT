package com.javarush.task.task29.task2909.car;

import java.util.Date;

<<<<<<< HEAD
public class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
=======
public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    static protected final int MAX_TRUCK_SPEED = 80;
    static protected final int MAX_SEDAN_SPEED = 120;
    static protected final int MAX_CABRIOLET_SPEED = 90;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
<<<<<<< HEAD
    private int numberOfPassengers;

    public Car(int type, int numberOfPassengers) {
=======
    protected int numberOfPassengers;

    protected Car() {

    }

    protected Car(int type, int numberOfPassengers) {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

<<<<<<< HEAD
    public int fill(double numberOfLiters) {
        if (numberOfLiters < 0)
            return -1;
        fuel += numberOfLiters;
        return 0;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (date.before(SummerStart) || date.after(SummerEnd)) {
            consumption = length * winterFuelConsumption + winterWarmingUp;
        } else {
            consumption = length * summerFuelConsumption;
=======
    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getWinterConsumption(int length) {
        return winterFuelConsumption * length + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return summerFuelConsumption * length;
    }


    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
<<<<<<< HEAD
        if (!isDriverAvailable())
            return 0;
        if (fuel <= 0)
            return 0;

=======
        if (!canPassengersBeTransferred())
            return 0;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
<<<<<<< HEAD
            fastenDriverBelt();
        } else {
            fastenDriverBelt();
        }
=======
        }
        fastenDriverBelt();
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

<<<<<<< HEAD
    public int getMaxSpeed() {
        if (type == TRUCK)
            return 80;
        if (type == SEDAN)
            return 120;
        return 90;
    }
=======
    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            default:
                return null;
        }

    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return !(date.before(summerStart) || date.after(summerEnd));
    }

    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() && fuel>0;
    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}