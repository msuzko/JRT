package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        String s = "";
        if (a>0)
            s =  "положительное ";
        else if (a<0)
            s = "отрицательное ";
        else {
            System.out.println("ноль");
            return;
        }
        if (a%2==0)
            s+="четное число";
        else
            s+="нечетное число";
        System.out.println(s);
    }
}
