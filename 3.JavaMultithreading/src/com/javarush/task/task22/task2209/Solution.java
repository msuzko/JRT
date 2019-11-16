package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerF = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader(readerF.readLine()));
        BufferedReader reader = new BufferedReader(new FileReader("/Users/mec/test/5.txt"));
        readerF.close();
        List<String> list = new ArrayList<>();
        while (reader.ready()) {
            list.addAll(Arrays.asList(reader.readLine().split(" ")));
        }
        reader.close();
        Collections.sort(list);
        String[] stockArr = new String[list.size()];
        stockArr = list.toArray(stockArr);

        StringBuilder result = getLine(stockArr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if (words == null || words.length == 0) return builder;
        if (words.length==1 || words[0].equals("")) return new StringBuilder(words[0]);

        String[] ss = words.clone();
        for (int i = 0; i < ss.length; i++) {
            String s1 = ss[i].toLowerCase();
            for (int j = i + 1; j < ss.length; j++) {
                String s2 = ss[j].toLowerCase();
                if (s1.charAt(s1.length() - 1) == s2.charAt(0)) {
                    String s = ss[i + 1];
                    ss[i + 1] = ss[j];
                    ss[j] = s;
                    break;
                }
            }
        }
        for (String s : ss) {
            builder.append(s).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder;
    }
}
