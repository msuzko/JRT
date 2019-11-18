package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        int n = Integer.parseInt(reader.readLine());
        int a;
        while (n>0){
            a = Integer.parseInt(reader.readLine());
            maximum = a > maximum ? a : maximum;
            n--;
        }

        System.out.println(maximum);
    }
}
