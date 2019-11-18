package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            String s = args[0];
            for (int i = 0; i <= 36; i++) {
                try {
                    new BigInteger(s, i);
                    System.out.println(i);
                    return;
                } catch (NumberFormatException ignored) {
                }
            }
        } catch (Exception ignored) {
        }
        System.out.println("incorrect");
    }
}