package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int index = 0;
        while (true){
            if (index == 0)
                s = s.substring(0,1).toUpperCase()+s.substring(1);

            index = s.indexOf(" ",index);
            if (index == -1) break;
            index++;
            if (s.length()>=index)
                s = s.substring(0,index)+s.substring(index,index+1).toUpperCase()+s.substring(index+1);
        }
        System.out.println(s);
    }
}
