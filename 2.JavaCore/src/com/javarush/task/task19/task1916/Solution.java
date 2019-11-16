package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader reader1 = new BufferedReader(new FileReader("/users/mec/test/1.txt"));
//        BufferedReader reader2 = new BufferedReader(new FileReader("/users/mec/test/2.txt"));

        bufferedReader.close();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String line;
        while ((line = reader1.readLine()) != null) list1.add(line);
        while ((line = reader2.readLine()) != null) list2.add(line);
        int i = 0;
        while (i < list1.size() || i < list2.size()) {
            if (i+1==list1.size() && i+1>list2.size()){
                lines.add(new LineItem(Type.REMOVED, list1.get(i++)));
                continue;
            }
            if (i+1==list2.size() && i+1>list1.size()){
                lines.add(new LineItem(Type.ADDED, list2.get(i++)));
                continue;
            }
            if (i < list2.size())
                if (list1.get(i).equals(list2.get(i))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i++)));
                    continue;
                }
            if (i + 1 < list2.size()) {
                if (list1.get(i).equals(list2.get(i + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    list1.add(i, list2.get(i++));
                    continue;
                }
            }
            if (i + 1 < list1.size()) {
                if (list1.get(i + 1).equals(list2.get(i))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list2.add(i, list1.get(i++));
                    continue;
                }
            }

        }

        reader1.close();
        reader2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
