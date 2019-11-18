package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    private static int countP, countO;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        checkNum(a);
        checkNum(b);
        checkNum(c);
        System.out.println("количество отрицательных чисел: "+countO);
        System.out.println("количество положительных чисел: "+countP);

    }

    private static void checkNum(int a) {
        if (a>0)
            countP++;
         else if (a<0)
            countO++;

    }
}
