package com.javarush.task.task39.task3909;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if ((first.isEmpty() && second.isEmpty()) || first.equals(second)) return true;
        int delta = Math.abs(first.length() - second.length());
        if (delta > 1) return false;

        StringBuffer longerString = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer shorterString = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);

        for (int i = 0; i < shorterString.length(); i++)
            if (longerString.charAt(i) != shorterString.charAt(i)) {
                if (delta == 0)
                    shorterString.deleteCharAt(i);
                longerString.deleteCharAt(i);
                break;
            }

        if (longerString.length() != shorterString.length())
            longerString.deleteCharAt(longerString.length() - 1);

        return longerString.toString().equals(shorterString.toString());
    }
}
