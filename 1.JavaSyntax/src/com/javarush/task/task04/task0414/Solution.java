package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        boolean v = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(reader.readLine());
        if (y%4==0)
            if (y%100==0) {
                if (y % 400 == 0)
                    v = true;
                else
                    v = false;
            }else
                v = true;
        if (v)
            System.out.println("количество дней в году: 366");
        else
            System.out.println("количество дней в году: 365");

    }
}