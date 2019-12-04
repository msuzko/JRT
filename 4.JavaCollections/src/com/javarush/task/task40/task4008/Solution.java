package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String dateStr) {
        String[] dateAndTime = dateStr.split(" ");
        String date = dateAndTime[0].contains(".") ? dateAndTime[0] : null;
        String time = dateAndTime[dateAndTime.length - 1].contains(":") ? dateAndTime[dateAndTime.length - 1] : null;
        showFieldsByDate(date);
        showFieldsByTime(time);

    }

    private static void showFieldsByTime(String time) {
        if (time == null) return;

        LocalTime dateTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println("AM или PM: " + (dateTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
        System.out.println("Часы: " + dateTime.get(ChronoField.HOUR_OF_AMPM));
        System.out.println("Часы дня: " + dateTime.getHour());
        System.out.println("Минуты: " + dateTime.getMinute());
        System.out.println("Секунды: " + dateTime.getSecond());
    }

    private static void showFieldsByDate(String date) {
        if (date == null) return;

        LocalDate dateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("d.M.yyyy"));
        System.out.println("День: " + dateTime.getDayOfMonth());
        System.out.println("День недели: " + dateTime.getDayOfWeek().getValue());
        System.out.println("День месяца: " + dateTime.getDayOfMonth());
        System.out.println("День года: " + dateTime.getDayOfYear());
        System.out.println("Неделя месяца: " + dateTime.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        System.out.println("Неделя года: " + dateTime.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("Месяц: " + dateTime.getMonthValue());
        System.out.println("Год: " + dateTime.getYear());
    }
}
