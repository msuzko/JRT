package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<10;i++)
            list.add(reader.readLine());

        ArrayList<String> result = doubleValues(list);

        for (String s :
                result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        int i=0;
        while (i<list.size()){
            list.add(i+1,list.get(i));
            i+=2;
        }

        return list;
    }
}
