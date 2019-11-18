package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        InputStream is = new FileInputStream("/users/mec/test/task1809.txt");
//        OutputStream out = new FileOutputStream("/users/mec/test/task1809_2.txt");
        InputStream is = new FileInputStream(reader.readLine());
        OutputStream out = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer = new byte[is.available()];
        int count = is.read(buffer);
        for(int i = count-1;i>=0;i--){
            out.write(buffer[i]);
        }
        is.close();
        out.close();
    }
}
