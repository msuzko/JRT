package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for (String s :
                getTokens("level22.lesson13.task01", ".")) {
            System.out.println(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        ArrayList<String> list = new ArrayList<>();
        while (st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        return list.toArray(new String[0]);
    }
}
