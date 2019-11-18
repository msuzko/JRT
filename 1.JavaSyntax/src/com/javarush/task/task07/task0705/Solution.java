package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bigList = new int[20];
        String s;
        for (int i = 0;i< bigList.length;i++){
            s = reader.readLine();
            bigList[i] = Integer.parseInt(s);
        }
        int[] small1List = new int[10];
        int[] small2List = new int[10];
        for (int i=0;i<10;i++) {
            small1List[i] = bigList[i];
        }
        for (int i=10;i<20;i++) {
            small2List[i-10] = bigList[i];
        }
        for (int i=0;i<10;i++)
            System.out.println(small2List[i]);


    }
}
