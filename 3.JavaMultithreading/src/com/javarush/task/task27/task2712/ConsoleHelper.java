package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
         return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюда:");
        String dish;
        while (!(dish = readString()).equals("exit")) {
            switch (dish.toLowerCase()) {
                case "fish":
                    dishes.add(Dish.Fish);
                    break;
                case "steak":
                    dishes.add(Dish.Steak);
                    break;
                case "soup":
                    dishes.add(Dish.Soup);
                    break;
                case "juice":
                    dishes.add(Dish.Juice);
                    break;
                case "water":
                    dishes.add(Dish.Water);
                    break;
                default:
                    writeMessage("Такого блюда нет");
            }
        }
        return dishes;
    }
}
