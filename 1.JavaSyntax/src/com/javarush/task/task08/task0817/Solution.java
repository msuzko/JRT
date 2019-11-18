package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String,String> map = new HashMap<>();
        map.put("Сузько","Михаил");
        map.put("Чикин","Александр");
        map.put("Гаврин","Алексей");
        map.put("Беликов","Михаил");
        map.put("Винокуров","Александр");
        map.put("Крапивин","Андрей");
        map.put("Струговщиков","Владимир");
        map.put("Чурилов","Дмитрий");
        map.put("Доманов","Максим");
        map.put("Федоров","Александр");

        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        HashMap<String,Integer> counts = new HashMap<>();
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            if (counts.containsKey(entry.getValue()))
                counts.put(entry.getValue(),counts.get(entry.getValue())+1);
            else
                counts.put(entry.getValue(),1);
        }
        for (Map.Entry<String,Integer> entry:
             counts.entrySet()) {
            if (entry.getValue()>1)
                removeItemFromMapByValue(map,entry.getKey());
        }


    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
