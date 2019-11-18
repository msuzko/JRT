package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
        try {
            Date date = oldFormat.parse(reader.readLine());
            System.out.println(newFormat.format(date).toUpperCase());
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
}
