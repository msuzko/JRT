package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//        {name=Ivanov, country=Ukraine, city=Kiev, age=null}
//        Map<String, String> map = new HashMap<>();
//        map.put("name","Ivanov");
//        map.put("country","Ukraine");
//        map.put("city","Kiev");
//        map.put("age",null);
//        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> entry :
                params.entrySet()) {
            if (entry.getValue() == null) continue;
            s.append(String.format("%s = '%s' and ",entry.getKey(), entry.getValue()));
        }
        if (s.length()>0)
            s.delete(s.length()-5,s.length());
        return s.toString();
    }
}
