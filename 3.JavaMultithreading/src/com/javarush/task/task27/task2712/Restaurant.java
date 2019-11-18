package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue =  new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Cook cook_1 = new Cook("Steev");
        cook_1.setQueue(orderQueue);
        Cook cook_2 = new Cook("Jake");
        cook_2.setQueue(orderQueue);

        Thread cook1Thread = new Thread(cook_1);
        cook1Thread.start();
        Thread cook2Thread = new Thread(cook_2);
        cook2Thread.start();

        Waiter waiter = new Waiter();
        cook_1.addObserver(waiter);
        cook_2.addObserver(waiter);

        List<Tablet> tablets = new ArrayList<>();
        for (int i=1; i<=5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }


        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        while (!orderQueue.isEmpty()){
            Thread.sleep(1);
        }

        while ((cook_1.isBusy())||(cook_2.isBusy())) { Thread.sleep(1);}
        cook1Thread.interrupt();
        cook2Thread.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();

//        Cook cook2 = new Cook("Amigo2");
//        cook2.addObserver(new Waiter());
//        tablet.addObserver(cook2);
//        tablet.createOrder();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
    }
}
