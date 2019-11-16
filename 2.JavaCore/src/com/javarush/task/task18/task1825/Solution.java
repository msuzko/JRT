package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new HashMap<>();
        String fileName="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            if (str.equals("end"))
                break;
            fileName = addToHash(str, map);
        }
        reader.close();

        OutputStream out = new FileOutputStream(fileName);

        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            InputStream is = new FileInputStream(entry.getValue());
            byte[] b = new byte[is.available()];
            is.read(b);
            out.write(b);
            is.close();
        }
        out.close();
    }

    private static String addToHash(String s, Map<Integer, String> map) {
        int index = s.indexOf(".part") + 5;
        map.put(Integer.valueOf(s.substring(index)), s);
        return s.substring(0, index - 5);
    }
}
