package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        String str = readStringFromFile(number, text.length(), file);
        text = str.equals(text)?"true":"false";
        writeTextToEndFile(text, file);

    }

    private static void writeTextToEndFile(String text, RandomAccessFile file) throws IOException {
        file.seek(file.length());
        file.write(text.getBytes());
    }

    private static String readStringFromFile(long number, int length, RandomAccessFile file) throws IOException {
        byte[] b = new byte[length];
        file.seek(number);
        file.read(b, 0, length);
        return new String(b);
    }
}
