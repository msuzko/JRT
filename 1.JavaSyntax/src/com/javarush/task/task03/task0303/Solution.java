package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(40,74));
        System.out.println(convertEurToUsd(270,73.2));

    }

    public static double convertEurToUsd(int eur, double course) {
        return eur*course;
    }
}
