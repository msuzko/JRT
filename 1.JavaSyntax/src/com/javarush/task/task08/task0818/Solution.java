package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Stallone", 100);
        map.put("Сузько", 10000);
        map.put("Набережных", 7000);
        map.put("Гаврин", 5000);
        map.put("Беликов", 6000);
        map.put("Винокуров", 600);
        map.put("Чикин", 400);
        map.put("Чурилов", 450);
        map.put("Крапивин", 300);
        map.put("Федоров", 200);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> map2 = new HashMap<>();
        for (Map.Entry<String, Integer> entry :
                map.entrySet())
            map2.put(entry.getKey(),entry.getValue());
        for (Map.Entry<String, Integer> entry :
                map2.entrySet()) {
            if (entry.getValue() < 500)
                map.remove(entry.getKey());
        }
    }

    public static void main(String[] args) {

    }
}