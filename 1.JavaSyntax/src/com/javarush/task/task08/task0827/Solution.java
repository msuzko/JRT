package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date dateNow = new Date(date);
        Date dateStart = new Date(date);
        dateStart.setMonth(0);
        dateStart.setDate(1);
        dateStart.setHours(0);
        dateStart.setMinutes(0);
        dateStart.setSeconds(0);
        int days = (int) ((dateNow.getTime()-dateStart.getTime())/86400000+1);
        return days%2!=0;
    }
}
