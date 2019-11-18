package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish :
                dishes) {
            time += dish.getDuration();
        }
        return time;
    }
    protected void initDishes(){
        try {
            dishes = ConsoleHelper.getAllDishesForOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        return "Your order: " + Arrays.toString(dishes.toArray()) + " of " + tablet;
    }
}
