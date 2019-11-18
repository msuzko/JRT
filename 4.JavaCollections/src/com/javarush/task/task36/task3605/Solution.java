package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        TreeSet<Character> tree = new TreeSet<>();
        while ((line = reader.readLine()) != null) {
            char[] b = line.toLowerCase().toCharArray();
            for (char c : b) {
                if (c>=97 && c<=122)
                    tree.add(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c : tree) {
            builder.append(c);
            count++;
            if (count==5) break;
        }
        System.out.println(builder.toString());
        fileReader.close();
        reader.close();

    }
}
