package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consolStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();
        System.setOut(consolStream);

        BufferedReader reader = new BufferedReader(new StringReader(outputStream.toString()));
        int count = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (count % 2 == 0)
                System.out.println("JavaRush - курсы Java онлайн");
            count++;
        }
        reader.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
