package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
<<<<<<< HEAD
=======
import com.javarush.task.task27.task2712.Tablet;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
<<<<<<< HEAD
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
=======
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public Cook(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public boolean isBusy() {
        return busy;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    @Override
    public String toString() {
        return name;
    }

<<<<<<< HEAD
    public void startCookingOrder(Order order) {
        busy = true;
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException ignored) {
        }
        setChanged();
        notifyObservers(order);
        busy = false;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!isBusy() && !queue.isEmpty()) {
                startCookingOrder(queue.poll());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
                return;
            }
        }
=======
    @Override
    public void update(Observable tablet, Object obj) {
        Order order = (Order) obj;
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(tablet.toString(), name, order.getTotalCookingTime()*60, order.getDishes()));
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
