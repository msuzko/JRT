package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        boolean is = false;
        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            for (String str :
                    s) {
                if (str.length() > 6) {
                    if (is)
                        writer.write(",");
                    writer.write(str);
                    is = true;
                }
            }
        }

        reader.close();
        writer.close();
    }
}
