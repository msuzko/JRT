package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("Steev");
        tablet.addObserver(cook);
        cook.addObserver(new Waiter());
        tablet.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
        Cook cook2 = new Cook("Amigo2");
        cook2.addObserver(new Waiter());
        tablet.addObserver(cook2);
        tablet.createOrder();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
