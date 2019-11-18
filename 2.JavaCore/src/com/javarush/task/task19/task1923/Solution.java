package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        Pattern p = Pattern.compile("\\d");
        while (reader.ready()){
            String s = reader.readLine();
            String[] ar = s.split(" ");
            for (String ss :
                    ar) {
                Matcher m = p.matcher(ss);
                if (m.find())
                    writer.write(ss+" ");
            }
        }

        reader.close();
        writer.close();
    }
}
