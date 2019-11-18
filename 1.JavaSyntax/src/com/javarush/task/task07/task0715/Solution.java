package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        int i=0;
        while (i<list.size()){
            list.add(i+1,"именно");
            i+=2;
        }
        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
