package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader reader = new BufferedReader(new FileReader("/users/mec/test/5.txt"));
        bufferedReader.close();
        while (reader.ready()){
            StringBuilder builder = new StringBuilder(reader.readLine());
            System.out.println(builder.reverse().toString());
        }
        reader.close();
    }
}
