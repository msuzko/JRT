package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String,Cat> map = new HashMap<>();
        map.put("Vasya1",new Cat("Vasya1"));
        map.put("Vasya2",new Cat("Vasya2"));
        map.put("Vasya3",new Cat("Vasya3"));
        map.put("Vasya4",new Cat("Vasya4"));
        map.put("Vasya5",new Cat("Vasya5"));
        map.put("Vasya6",new Cat("Vasya6"));
        map.put("Vasya7",new Cat("Vasya7"));
        map.put("Vasya8",new Cat("Vasya8"));
        map.put("Vasya9",new Cat("Vasya9"));
        map.put("Vasya10",new Cat("Vasya10"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>();
            set.addAll(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
