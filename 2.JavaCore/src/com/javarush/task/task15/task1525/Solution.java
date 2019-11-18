package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {


    public static List<String> lines = new ArrayList<String>();

    static{
        try {
            String str ="";
            char newLine = "\n".charAt(0);
            InputStream is = new FileInputStream(Statics.FILE_NAME);
            while(is.available()>0) {
                char ch = (char) is.read();
                if (ch == newLine) {
                    lines.add(str);
                    str = "";
                } else {
                    str += ch;
                }
            }
                if (!str.isEmpty())
                    lines.add(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
