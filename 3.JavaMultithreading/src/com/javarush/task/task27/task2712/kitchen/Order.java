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
<<<<<<< HEAD
        initDishes();
=======
        dishes = ConsoleHelper.getAllDishesForOrder();
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public int getTotalCookingTime() {
        int time = 0;
        for (Dish dish :
                dishes) {
            time += dish.getDuration();
        }
        return time;
    }
<<<<<<< HEAD
    protected void initDishes(){
        try {
            dishes = ConsoleHelper.getAllDishesForOrder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

<<<<<<< HEAD
    public Tablet getTablet() {
        return tablet;
    }

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    @Override
    public String toString() {
        return "Your order: " + Arrays.toString(dishes.toArray()) + " of " + tablet;
    }
}
