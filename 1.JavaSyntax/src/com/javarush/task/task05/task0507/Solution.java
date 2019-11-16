package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, count=0;
        double sum=0;
        while (true){
            a = Integer.parseInt(reader.readLine());
            if (a==-1)
                break;
            count++;
            sum+=a;
        }
        double result=0;
        if (count!=0)
            result = sum/count;
        System.out.println(result);
    }
}

