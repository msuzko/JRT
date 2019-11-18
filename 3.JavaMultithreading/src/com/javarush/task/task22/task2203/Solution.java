package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty())
            throw new TooShortStringException();
        int fIndex = string.indexOf("\t")+1;
        int lIndex = string.indexOf("\t",fIndex);
        if (lIndex == -1)
            throw new TooShortStringException();
        return string.substring(fIndex,lIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        //System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java\t."));
    }
}
