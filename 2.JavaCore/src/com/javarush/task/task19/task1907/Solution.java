package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fReader = new FileReader(reader.readLine());
//        FileReader fReader = new FileReader("/users/mec/test/1.txt");
        reader.close();
        int count = 0;
        StringBuilder s = new StringBuilder();
        while (fReader.ready()) {
            s.append((char) fReader.read());
        }
        fReader.close();
        for (String x : s.toString().toLowerCase().split("[^a-zA-Z0-9]")) {
            if (x.equals("world")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
