package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();//"/users/mec/test/BW.txt";
        reader.close();

        InputStream is = new FileInputStream(file);
        Integer max = Integer.MIN_VALUE;
        while (is.available()>0){
            int i = is.read();
            if (i>max)
                max = i;
        }
        is.close();
        System.out.println(max);
    }
}
