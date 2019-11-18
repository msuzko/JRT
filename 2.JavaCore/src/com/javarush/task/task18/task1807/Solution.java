package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        file = reader.readLine();
//        file = "/users/mec/test/BW3.txt";
        reader.close();
        int zpt = ',';
        int count = 0;
        InputStream is = new FileInputStream(file);
        List<Integer> list = new ArrayList<>();
        while (is.available() > 0) {
            if (is.read() == zpt)
                count++;
        }
        is.close();
        System.out.println(count);
    }
}
