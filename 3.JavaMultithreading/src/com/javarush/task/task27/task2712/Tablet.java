package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
<<<<<<< HEAD
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;
=======
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;
import javafx.beans.InvalidationListener;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public Tablet(int number) {
        this.number = number;
    }

<<<<<<< HEAD
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void createOrder() {
        try {
            startAdvertisementAndNotifyCook(new Order(this));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void startAdvertisementAndNotifyCook(Order order) {
        System.out.println(order);
        if (!order.isEmpty()) {
            try {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
            try {
                queue.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTestOrder(){
        try {
            startAdvertisementAndNotifyCook(new TestOrder(this));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
=======
    public Order createOrder() {
        try {
            Order order = new Order(this);
            System.out.println(order);
            if (!order.isEmpty()) {
                try {
                    new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
                } catch (NoVideoAvailableException e){
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
                setChanged();
                notifyObservers(order);
            }
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }

}
