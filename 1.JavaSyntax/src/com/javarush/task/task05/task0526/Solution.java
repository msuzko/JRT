package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1=new Man("Petr",20,"Moscow");
        Man man2=new Man("Kolya",23,"Mozyr");
        System.out.println(man1);
        System.out.println(man2);

        Woman woman=new Woman("Olya",22,"Minsk");
        Woman woman1=new Woman("Katya",28,"Buda");
        System.out.println(woman);
        System.out.println(woman1);

    }

    public static class Man{
        String name;
        int age;
        String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

}
