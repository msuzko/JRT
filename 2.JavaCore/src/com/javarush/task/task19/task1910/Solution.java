package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fReader = new BufferedReader(new FileReader("/users/mec/test/1.txt"));
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/users/mec/test/2.txt"));
        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        StringBuilder builder = new StringBuilder(" ");
        while(fReader.ready()){
            builder.append(fReader.readLine());
        }
        String s = builder.toString().replaceAll("[\\p{P}]","")
              //  .replaceAll("!","")
                //.replaceAll("\\?","")
                //.replaceAll("\\,","")
                //.replaceAll("\\\n","")
        ;
//        System.out.println(s);
        writer.write(s);
        fReader.close();
        writer.close();
    }
}
