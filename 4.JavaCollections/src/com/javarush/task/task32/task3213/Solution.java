package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();
        if (reader!= null){
            String line;
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((line = bufferedReader.readLine())!=null){
                 byte[] b = line.getBytes();
                 for(int i=0;i<b.length;i++){
                     b[i] = (byte) (b[i]+key);
                 }
                writer.write(new String(b));
            }
        }
        return writer.toString();
    }
}
