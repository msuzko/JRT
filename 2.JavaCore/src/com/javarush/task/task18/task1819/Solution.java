package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        InputStream in = new FileInputStream(file1);
        byte[] buffer1 = new byte[in.available()];
        if (in.available()>0){
            in.read(buffer1);
        }
        in.close();
        in = new FileInputStream(file2);
        byte[] buffer2 = new byte[in.available()];
        if (in.available()>0){
            in.read(buffer2);
        }
        in.close();
//        PrintWriter writer = new PrintWriter(file1);
//        writer.print("");
//        writer.close();

        OutputStream out = new FileOutputStream(file1);
        out.write(buffer2);
        out.write(buffer1);
        out.close();

    }
}
