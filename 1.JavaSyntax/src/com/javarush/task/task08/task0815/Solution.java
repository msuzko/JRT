package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
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

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count=0;
        for (Map.Entry<String, String> entry :
                map.entrySet()) {
            if (entry.getValue().equals(name))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        return map.containsKey(lastName)?1:0;
    }


    public static void main(String[] args) {

    }
}
