package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        String s = telNumber.replaceAll("\\D","");
        if (telNumber.contains("[a-aA-Z]")) {return false;}
        if (s.length() == 12){
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*-?\\d*-?\\d*\\d$");
        }else if (s.length() == 10){
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*-?\\d+?-?\\d*\\d$");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("+050ххх4567"));


    }
}
