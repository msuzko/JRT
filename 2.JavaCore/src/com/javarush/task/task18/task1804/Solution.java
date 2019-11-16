package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();//"/users/mec/test/BW.txt";
//        file = "/users/mec/test/BW.txt";
        reader.close();

        InputStream is = new FileInputStream(file);
        Map<Integer, Integer> map = new HashMap<>();
        while (is.available() > 0) {
            Integer i = is.read();
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, ++count);
            } else map.put(i,1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer value :
                map.values()) {
            if (min>value)
                min = value;
        }
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() == min)
                System.out.print(entry.getKey()+" ");
        }
        is.close();
    }
}
