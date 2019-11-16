package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();
        System.setOut(consolStream);

        String s = outputStream.toString();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        m.find();
        int a = Integer.valueOf(m.group());
        m.find();
        int b = Integer.valueOf(m.group());
        int result = 0;
        if (s.contains("+"))
            result = a+b;
        else if (s.contains("-"))
            result = a-b;
        else if (s.contains("*"))
            result = a*b;

        System.out.println(s.substring(0,s.length()-1)+result);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

