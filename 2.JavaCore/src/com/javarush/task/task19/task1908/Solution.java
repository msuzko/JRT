package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader("/users/mec/test/1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/users/mec/test/2.txt"));
//        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        StringBuilder builder = new StringBuilder(" ");
        while(fReader.ready()){
            builder.append(fReader.readLine());
        }
        Pattern p = Pattern.compile("( \\d+ )");
        Matcher m = p.matcher(builder.append(" ").toString());
        builder = new StringBuilder();
        while(m.find()){
            builder.append(m.group().trim()).append(" ");
        }
        System.out.println(builder.toString());
        writer.write(builder.toString());
        fReader.close();
        writer.close();
    }
}
