package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        if (a==b)
            if (a==c)
                System.out.println(a+" "+a+" "+a);
            else
                System.out.println(a+" "+a);
        else if (b==c)
            System.out.println(b+" " + b);
        else if (a==c)
            System.out.println(a+" "+a);
    }
}