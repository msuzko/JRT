package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String fileName = "/users/mec/test/task1821.txt";
        String fileName = args[0];
        InputStream is = new FileInputStream(fileName);
        byte[] data = new byte[is.available()];
        is.read(data);
        is.close();
        Map<Byte, Integer> map = new HashMap();
        for (byte b :
                data) {
            if (map.containsKey(b)) {
                int count = map.get(b);
                map.put(b, ++count);
            } else map.put(b, 1);
        }

        List<Map.Entry<Byte, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());

        for (Map.Entry<Byte, Integer> entry :
                list) {
            char ch = (char) entry.getKey().byteValue();
            System.out.println(ch + " " + entry.getValue());
//            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

}
