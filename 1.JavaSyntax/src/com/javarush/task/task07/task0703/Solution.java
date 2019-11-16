package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] listS = new String[10];
        int[] listI = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++)
            listS[i] = reader.readLine();
        for(int i=0;i<10;i++)
            listI[i]=listS[i].length();
        for(int i=0;i<10;i++)
            System.out.println(listI[i]);
    }
}
