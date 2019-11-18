package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = new FileInputStream(reader.readLine());
        OutputStream out = new FileOutputStream(reader.readLine());
        reader.close();

        if (is.available()>0){
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            String[] mas = new String(buffer).split(" ");
            for (String s :
                    mas) {
                out.write(String.valueOf(Math.round(Float.valueOf(s))+" ").getBytes());
            }
        }

        is.close();
        out.close();
    }
}
