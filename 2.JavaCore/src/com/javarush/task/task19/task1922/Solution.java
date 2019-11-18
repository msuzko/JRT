package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader reader = new BufferedReader(new FileReader("/users/mec/test/5.txt"));
        bufferedReader.close();

        while (reader.ready()){
            String s = reader.readLine();
            int count = 0;
            String[] array = s.split(" ");
            for (String ss :
                    array) {
                if (words.contains(ss)) count++;
            }
            if (count == 2) System.out.println(s);
        }

        reader.close();
    }
}
