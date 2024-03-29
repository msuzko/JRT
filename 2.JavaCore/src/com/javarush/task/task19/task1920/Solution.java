package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedReader reader = new BufferedReader(new FileReader("/users/mec/test/3.txt"));

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            if (map.containsKey(s[0])){
                map.put(s[0],map.get(s[0])+Double.valueOf(s[1]));
            } else
                map.put(s[0],Double.valueOf(s[1]));

        }
        reader.close();
        double max = Double.MIN_VALUE;
        for (double value :
                map.values()) {
            if (max < value)
                max = value;
        }
        for (Map.Entry<String, Double> entry :
                map.entrySet()) {
            if (entry.getValue()==max)
                System.out.println(entry.getKey());
        }
    }
}
