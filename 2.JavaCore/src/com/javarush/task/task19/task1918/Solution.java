package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String str = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
//                "</span></b></span><span>Super</span><span>girl</span>";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
//        BufferedReader reader = new BufferedReader(new FileReader("/users/mec/test/5.txt"));
        bufferedReader.close();

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null)
            builder.append(line);
        reader.close();
        String str = builder.toString().replaceAll("\n", " ").replaceAll("\r", " ");
        parse(str,args[0]);
//        parse(str, "t");
    }

    public static void parse(String sub, String teg) {
        String ss = sub;

        String tegStart = "<" + teg;
        String tegEnd = "</" + teg + ">";
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        while (ss.contains(tegStart + " ") || ss.contains(tegStart + ">")) {
            int i = ss.indexOf(tegStart + " ");
            int j = ss.indexOf(tegStart + ">");
            if (i != -1 && j != -1)
                if (i < j) {
                    starts.add(i);
                    ss = ss.replaceFirst(tegStart + " ", getX(tegStart + " "));
                } else {
                    starts.add(j);
                    ss = ss.replaceFirst(tegStart + ">", getX(tegStart + ">"));
                }
            else if (i != -1) {
                starts.add(i);
                ss = ss.replaceFirst(tegStart + " ", getX(tegStart + " "));
            } else if (j != -1) {
                starts.add(j);
                ss = ss.replaceFirst(tegStart + ">", getX(tegStart + ">"));
            }
        }

        while (ss.contains(tegEnd)) {
            ends.add(ss.indexOf(tegEnd));
            ss = ss.replaceFirst(tegEnd, getX(tegEnd));
        }
        SortedMap<Integer, String> map = new TreeMap<>();
        while (starts.size() > 0) {
            int minIndexStart = 0, minIndexEnd = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < starts.size(); i++) {
                for (int j = 0; j < starts.size(); j++) {
                    int value = ends.get(j) - starts.get(i);
                    if (value > 0 && value < min) {
                        min = value;
                        minIndexStart = i;
                        minIndexEnd = j;
                    }
                }
            }
            map.put(starts.get(minIndexStart), sub.substring(starts.get(minIndexStart), ends.get(minIndexEnd) + tegEnd.length()));
            starts.remove(minIndexStart);
            ends.remove(minIndexEnd);
        }
        for (String str :
                map.values()) {
            System.out.println(str);
        }
    }

    private static String getX(String teg) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < teg.length(); i++) builder.append("x");
        return builder.toString();
    }

    private static void parse2(String sub, String teg) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        String tag = "<" + teg;
        String tagClose = "</" + teg + ">";
        StringBuilder sb = new StringBuilder(sub);
        List<Integer> openTag = new ArrayList();
        List<Integer> closeTag = new ArrayList();
        openTag.add(sb.indexOf(tag));
        closeTag.add(sb.indexOf(tagClose));
        for (int i = 1; i < countIn(tag, sub); i++) {
            openTag.add(sb.indexOf(tag, openTag.get(i - 1) + 1));
            closeTag.add(sb.indexOf(tagClose, closeTag.get(i - 1) + 1));
        }

        while (true) {
            if (closeTag.size() == 1) {
                break;
            }
            for (int j = 0; j < openTag.size(); ) {
                if ((closeTag.get(0) - openTag.get(j)) > 0) {
                    j++;
                } else {
                    map.put(openTag.get(j - 1), closeTag.get(0));
                    if (openTag.size() > 1)
                        openTag.remove(j - 1);
                    if (closeTag.size() > 1)
                        closeTag.remove(0);

                    if (openTag.size() == 1) {
                        map.put(openTag.get(0), closeTag.get(0));
                        break;
                    }

                    j = 0;
                }
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println(sub.substring(key, value + tagClose.length()));
        }
    }

    public static int countIn(String tag, String line) {
        int in = 0;
        int temp;
        StringBuilder restLine = new StringBuilder(line);

        String newLine;
        while (true) {
            temp = restLine.indexOf(tag) + tag.length();
            in++;
            restLine.delete(0, temp);
            newLine = restLine.toString();
            if (!newLine.contains(tag))
                break;
        }
        return in;
    }
}
