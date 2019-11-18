package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();//"/users/mec/test/BW.txt";
//        file = "/users/mec/test/BW.txt";
        reader.close();

        InputStream is = new FileInputStream(file);
        List<Integer> list = new ArrayList<>();
        while (is.available() > 0) {
            Integer i = is.read();
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        Collections.sort(list);
        for (Integer i:list){
            System.out.print(i+" ");

        }
        is.close();
    }
}
