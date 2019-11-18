package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/*
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String nameIn = args[0];
        String nameOut = args[1];
        InputStream is = new FileInputStream(nameIn);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        String s = new String(buffer, Charset.forName("Windows-1251"));
        buffer = s.getBytes(Charset.forName("UTF-8"));
        OutputStream out = new FileOutputStream(nameOut);
        out.write(buffer);
        out.close();


    }
}
