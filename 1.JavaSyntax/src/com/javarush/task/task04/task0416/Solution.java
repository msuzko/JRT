package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        int min5Count = (int) t/5;
        t = t-min5Count*5;
        if (t<3)
            System.out.println("зелёный");
        else if (t<4)
            System.out.println("жёлтый");
        else
            System.out.println("красный");
    }
}