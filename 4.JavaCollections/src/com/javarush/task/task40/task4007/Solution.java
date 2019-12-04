package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        SimpleDateFormat formatter;
        Calendar calendar = Calendar.getInstance();

        try {
            if (isDate(date)) {
                formatter = new SimpleDateFormat("dd.MM.yy");
                calendar.setTime(formatter.parse(date));
                showFieldsByDate(calendar);
            } else if (isTime(date)) {
                formatter = new SimpleDateFormat("HH:mm:ss");
                calendar.setTime(formatter.parse(date));
                showFieldsByTime(calendar);
            } else {
                formatter = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
                calendar.setTime(formatter.parse(date));
                showFieldsByDate(calendar);
                showFieldsByTime(calendar);
            }
        } catch (ParseException ignored) {
        }
    }

    private static boolean isTime(String date) {
        return date.matches("^\\d*:\\d*:\\d*$");
    }

    private static boolean isDate(String date) {
        return date.matches("^\\d*\\.\\d*\\.\\d*$");
    }

    private static void showFieldsByTime(Calendar calendar) {
        System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM"));
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
    }

    private static void showFieldsByDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DATE));
        System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + calendar.get(Calendar.YEAR));
    }
}
