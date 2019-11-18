package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();//"/users/mec/test/BW.txt";
        //file = "/users/mec/test/BW.txt";
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
        int max = 0;
        for (Integer value :
                map.values()) {
            if (max<value)
                max = value;
        }
        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() == max)
                System.out.print(entry.getKey()+" ");
        }
        is.close();

    }
}
