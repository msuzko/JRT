package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c=0,a;
        while (true){
            a = Integer.parseInt(reader.readLine());
            c+=a;
            if (a==-1)
                break;
        }
        System.out.println(c);
    }
}
