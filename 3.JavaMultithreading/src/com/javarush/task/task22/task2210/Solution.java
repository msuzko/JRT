package com.javarush.task.task22.task2210;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
=======
/* 
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
<<<<<<< HEAD
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
=======

    }
    public static String [] getTokens(String query, String delimiter) {
        return null;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
