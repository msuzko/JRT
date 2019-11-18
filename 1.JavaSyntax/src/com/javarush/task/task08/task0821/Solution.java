package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String,String> map = new HashMap<>();
        map.put("Сузько","Михаил");
        map.put("Чикин","Александр");
        map.put("Гаврин","Алексей");
        map.put("Беликов","Михаил");
        map.put("Винокуров","Александр");
        map.put("Крапивин","Андрей");
        map.put("Струговщиков","Владимир");
        map.put("Чурилов","Дмитрий");
        map.put("Доманов","Максим");
        map.put("Сузько","Александр");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
