package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (true) {
            str = reader.readLine();
            if (str.equals("exit")) break;
            if (str.contains(".")) {
                try {
                    print(Double.parseDouble(str));
                } catch (Exception e) {
                    print(str);
                }
            } else {
                try {
                    short sh = Short.parseShort(str);
                    if (sh > 0 && sh < 128) {
                        print(sh);
                        continue;
                    }
                } catch (Exception e) {
                }
                try {
                    Integer i = Integer.parseInt(str);
                    print(i);
                } catch (Exception e) {
                    print(str);

                }
            }
    }

        reader.close();
}

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
