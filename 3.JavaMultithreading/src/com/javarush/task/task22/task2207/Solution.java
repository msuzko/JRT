package com.javarush.task.task22.task2207;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader is = new BufferedReader(new FileReader(name));
        StringBuilder builder = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while (is.ready())
        {
            builder.append(is.readLine()).append(" ");
        }
        is.close();
        list.addAll(Arrays.asList(builder.toString().split(" ")));
        for (int i = 0; i < list.size()-1; i++) {
            String s1 = list.get(i);
            for (int j = i; j < list.size(); j++) {
                if (i != j) {
                    boolean matches = true;
                    String s2 = list.get(j);
                    if (s1.length() == s2.length()) {
                        char[] s1ar = s1.toCharArray();
                        char[] s2ar = s2.toCharArray();
                        for (int k = 0; k < s1ar.length; k++) {
                            if (s1ar[k] != s2ar[s2ar.length - k-1]){
                                matches = false;
                                break;
                            }
                        }
                        if (matches) {
                            Pair pair = new Pair();
                            pair.first = s1;
                            pair.second = s2;
                            if (!result.contains(pair))
                                result.add(pair);
                        }
                    }
                }
            }
        }
        for (Pair p :
                result) {
            System.out.println(p);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
