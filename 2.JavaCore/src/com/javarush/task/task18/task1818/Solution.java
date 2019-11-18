package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new FileOutputStream(reader.readLine());
        InputStream is2 = new FileInputStream(reader.readLine());
        InputStream is3 = new FileInputStream(reader.readLine());
        reader.close();

        write(out, is2);
        is2.close();
        write(out, is3);
        is3.close();
        out.close();

    }

    private static void write(OutputStream out, InputStream stream) throws IOException {
        if (stream.available()>0){
            byte[] buffer =new byte[stream.available()];
            stream.read(buffer);
            out.write(buffer);
        }
    }
}
