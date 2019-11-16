package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-d")) {
            code(args[1],args[2], -1);
        } else if (args[0].equals("-e")) {
            code(args[1],args[2],1);
        }
    }

    private static void code(String fileName, String fileOutputName,int b) throws IOException {
        InputStream is = new FileInputStream(fileName);
        OutputStream out = new FileOutputStream(fileOutputName);
        while(is.available()>0){
            int i = is.read();
            out.write(i+b);
        }
        out.close();
        is.close();
    }


}
