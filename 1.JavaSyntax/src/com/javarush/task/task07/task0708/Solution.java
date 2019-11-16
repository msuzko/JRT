package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<5;i++)
            strings.add(reader.readLine());
        int max = strings.get(0).length();
        for (int i=1;i<strings.size();i++){
            int l = strings.get(i).length();
            if (l>max)
                max = l;
        }
        for (String string : strings)
            if (string.length() == max)
                System.out.println(string);
    }
}
