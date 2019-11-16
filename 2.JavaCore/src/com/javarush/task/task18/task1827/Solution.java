package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String fileName = "/users/mec/test/task1827.txt";

        reader.close();
//        args = new String[]{"-c", "Ноутбук такой-то", "9999.99", "100"};
        if (args.length > 0) {
            String id = getNextId(fileName);
//            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)));
            OutputStream out = new FileOutputStream(fileName,true);
            String s = setSpaces(id, 8) +//id
                    setSpaces(args[1], 30) +//product
                    setSpaces(args[2], 8) +//price
                    setSpaces(args[3], 4) //quantity
                    ;
            out.write("\n".getBytes());
            out.write(s.getBytes());
            out.close();
//            printWriter.println(s);
//            printWriter.close();
        }
    }

    private static String getNextId(String fileName) throws IOException {
        ArrayList<Long> allIds = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        Long currentId;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.substring(0, 8).replaceAll("\\s", "");
            currentId = Long.parseLong(line);
            allIds.add(currentId);
        }
        bufferedReader.close();
        Long maxId = Collections.max(allIds);
        Long MyId = maxId + 1;
        return MyId.toString();
    }

    private static String setSpaces(String previousName, int count) {
        String trueName;
        if (previousName.length() > count) {
            trueName = previousName.substring(0, count);
        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < (count - previousName.length()); i++) {
                s.append(" ");
            }
            trueName = previousName + s;
        }
        return trueName;
    }

}
