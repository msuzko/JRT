package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(getPartOfString("JavaRush - лучший сервис"));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
            if (string == null || string.isEmpty())
                throw new TooShortStringException();
            int i = 0;
            int index = 0;
            while (i < 4) {
                index = string.indexOf(" ", index) + 1;
                if (index==0)
                    throw new TooShortStringException();
                i++;
            }
            int lastIndex = string.indexOf(" ", index);
            if (lastIndex == -1)
                return string.substring(string.indexOf(" ") + 1);
            else
                return string.substring(string.indexOf(" ") + 1, lastIndex);

    }

    public static class TooShortStringException extends RuntimeException{

    }
}
