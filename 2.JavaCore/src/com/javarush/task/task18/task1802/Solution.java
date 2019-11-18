package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();//"/users/mec/test/BW.txt";
        reader.close();

        InputStream is = new FileInputStream(file);
        Integer min = Integer.MAX_VALUE;
        while (is.available()>0){
            int i = is.read();
            if (i<min)
                min = i;
        }
        is.close();
        System.out.println(min);
    }
}
