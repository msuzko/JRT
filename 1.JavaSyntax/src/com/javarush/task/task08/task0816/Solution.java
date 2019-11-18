package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Сузько", df.parse("SEPTEMBER 1 1980"));
        map.put("Набережных", df.parse("JULY 1 1980"));
        map.put("Гаврин", df.parse("MARCH 1 1980"));
        map.put("Беликов", df.parse("MAY 1 1980"));
        map.put("Винокуров", df.parse("JUNE 1 1980"));
        map.put("Чикин", df.parse("DECEMBER 1 1980"));
        map.put("Чурилов", df.parse("JUNE 1 1980"));
        map.put("Крапивин", df.parse("MARCH 1 1980"));
        map.put("Федоров", df.parse("APRIL 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        HashMap<String, Date> map2 = new HashMap<>();
        for (Map.Entry<String, Date> entry :
                map.entrySet())
                map2.put(entry.getKey(),entry.getValue());
        for (Map.Entry<String, Date> entry :
                map2.entrySet()) {
            if (entry.getValue().getMonth() >= 5 && entry.getValue().getMonth() < 8)
                map.remove(entry.getKey());
        }

    }

    public static void main(String[] args) {

    }
}
