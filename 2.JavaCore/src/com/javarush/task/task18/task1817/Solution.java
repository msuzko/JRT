package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        //String fileName = "/users/mec/test/task1817.txt";
        InputStream is = new FileInputStream(fileName);
        int count = 0, l = is.available();
        int whiteSpace = ' ';
        while (is.available()>0){
            if (is.read() == whiteSpace)
                count++;
        }
        is.close();
        System.out.println(Math.rint(100.0 * count/l*100) / 100.0);

    }
}
