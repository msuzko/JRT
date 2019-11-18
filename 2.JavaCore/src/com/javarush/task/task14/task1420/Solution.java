package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,b;
            a = Integer.parseInt(reader.readLine());
            if (a<=0) throw new Exception();
            b = Integer.parseInt(reader.readLine());
            if (b<=0) throw new Exception();
        int max = 1;
        for (int i=2;i<=(a<b?a:b);i++){
            if (a%i==0 && b%i==0)
                max = i;
        }
        System.out.println(max);

        reader.close();
    }
}
