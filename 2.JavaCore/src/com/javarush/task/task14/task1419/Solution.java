package com.javarush.task.task14.task1419;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.rmi.activation.ActivationException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {//1
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {//2
            throw new IllegalArgumentException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//3
            throw new ActivationException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//4
            throw new PrinterException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//5
            throw new IOException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//6
            throw new IllegalAccessException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//
            throw new IndexOutOfBoundsException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//
            throw new RuntimeException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//
            throw new ClassCastException();
        } catch (Exception e){
            exceptions.add(e);
        }
        try {//
            throw new NullPointerException();
        } catch (Exception e){
            exceptions.add(e);
        }


    }
}
