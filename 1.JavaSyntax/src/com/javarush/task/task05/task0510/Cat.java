package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private static String DEFALT_COLOR = "grey";
    private static int DEFAULT_AGE = 3;
    private static int DEFAULT_WEIGHT = 4;

    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public static void main(String[] args) {

    }

    public void initialize(String name){
        this.name = name;
        age = DEFAULT_AGE;
        weight = DEFAULT_WEIGHT;
        color = DEFALT_COLOR;
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = DEFALT_COLOR;
    }

    public void initialize(String name, int age){
        this.name = name;
        this.weight = DEFAULT_WEIGHT;
        this.age = age;
        color = DEFALT_COLOR;
    }

    public void initialize(int weight, String color){
        this.weight = weight;
        this.age = DEFAULT_AGE;
        this.color = color;
    }

    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.age = DEFAULT_AGE;
        this.color = color;
        this.address = address;
    }

}
