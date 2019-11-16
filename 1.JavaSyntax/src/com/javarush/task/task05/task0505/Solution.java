package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska",3,4,10);
        Cat cat2 = new Cat("Tom",2,2,8);
        Cat cat3 = new Cat("Pushok",4,5,9);
        go(cat1,cat2);
        go(cat2,cat3);
        go(cat3,cat1);
    }

    private static void go(Cat cat1, Cat cat2) {
        if (cat1.fight(cat2))
            System.out.println(cat1.name + " won " + cat2.name);
        else
            System.out.println(cat1.name + " didn't win " + cat2.name);

    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
