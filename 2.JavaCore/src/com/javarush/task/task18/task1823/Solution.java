package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            if (str.equals("exit"))
                break;
            ReadThread readThread = new ReadThread(str);
            readThread.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String file;

        public ReadThread(String fileName) {
            file = fileName;
        }

        @Override
        public void run() {
            super.run();
            try {
                InputStream is = new FileInputStream(file);
                Map<Integer, Integer> map = new HashMap<>();
                while (is.available() > 0) {
                    Integer i = is.read();
                    if (map.containsKey(i)) {
                        int count = map.get(i);
                        map.put(i, ++count);
                    } else map.put(i,1);
                }
                int max = 0;
                for (Integer value :
                        map.values()) {
                    if (max<value)
                        max = value;
                }
                for (Map.Entry<Integer, Integer> entry :
                        map.entrySet()) {
                    if (entry.getValue() == max) {
                        resultMap.put(file, entry.getKey());
                        break;
                    }
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
