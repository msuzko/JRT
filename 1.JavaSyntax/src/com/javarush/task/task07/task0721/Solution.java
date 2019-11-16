package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] list = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<20;i++)
            list[i]=Integer.parseInt(reader.readLine());
        int maximum = list[0];
        int minimum = list[0];
        for (int i=1;i<20;i++){
            if (list[i]>maximum)
                maximum = list[i];
            if (list[i]<minimum)
                minimum = list[i];

        }

        System.out.print(maximum + " " + minimum);
    }
}
