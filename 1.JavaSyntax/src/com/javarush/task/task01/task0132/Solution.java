package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int a = number/100;
        int b = (number-a*100)/10;
        int c = number-a*100-b*10;
        return a+b+c;
    }
}