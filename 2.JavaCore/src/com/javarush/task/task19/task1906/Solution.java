package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader("/users/mec/test/1.txt");
//        FileWriter writer = new FileWriter("/users/mec/test/2.txt");
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter writer = new FileWriter(reader.readLine());
        reader.close();
        int i=1;
        while(fileReader.ready()){
            int a = fileReader.read();
            if (i%2==0)
                writer.write(a);
            i++;
        }


        fileReader.close();
        writer.close();
    }
}
