package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    final int WEIGHT = 3;
    final int AGE = 2;
    final String COLOR = "Grey";
    String name;
    int age;
    int weight;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
        this.age = AGE;
        this.color = COLOR;
        this.weight = WEIGHT;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = COLOR;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = WEIGHT;
        this.color = COLOR;
    }

    public Cat(int weight, String color) {
        this.age = AGE;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.age = AGE;
        this.weight = weight;
        this.color = color;
        this.address = address;

    }

    public static void main(String[] args) {

    }
}
