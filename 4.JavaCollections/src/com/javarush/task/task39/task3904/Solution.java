package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Лестница
*/
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) return 0;
        List<Long> list = new ArrayList<>(Arrays.asList(1L, 1L, 2L, 4L));
        for (int i = 4; i <= n; i++)
            list.add(list.get(i - 1) + list.get(i - 2) + list.get(i - 3));
        return list.get(n);
    }
}

