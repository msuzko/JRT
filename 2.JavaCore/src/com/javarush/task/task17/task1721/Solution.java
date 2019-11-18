package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static String file1, file2;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1 = reader.readLine();//"/users/mec/test/BW.txt";
            file2 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        while ((line = reader.readLine()) != null) {
            allLines.add(line);
        }
        reader.close();
        reader = new BufferedReader(new FileReader(file2));
        while ((line = reader.readLine()) != null)
            forRemoveLines.add(line);
        reader.close();
        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        for (String str : forRemoveLines) {
            if (allLines.contains(str)) {
                allLines.remove(str);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
