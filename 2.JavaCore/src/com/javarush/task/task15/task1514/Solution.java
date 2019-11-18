package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {

    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(4.3,"aa");
        labels.put(5.2, "qw");
        labels.put(3.1, "e");
        labels.put(2.6, "ty");
        labels.put(4.6, "yuw");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
