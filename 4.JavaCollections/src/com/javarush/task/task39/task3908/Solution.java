package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toLowerCase().toCharArray();
        for (char aChar : chars)
            if (map.containsKey(aChar))
                map.put(aChar, map.get(aChar) + 1);
            else
                map.put(aChar, 1);
            int odd = 0;
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()%2!=0)
                odd++;
        }
        return odd<=1;
    }
}
