package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        //String fileName = "/users/mec/test/task1816.txt";
        InputStream is = new FileInputStream(fileName);

        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m;
        int count=0;
        while (is.available()>0){
            m= p.matcher(String.valueOf((char)is.read()));
            if (m.matches())
                count++;
        }
        System.out.println(count);
        is.close();

    }
}
