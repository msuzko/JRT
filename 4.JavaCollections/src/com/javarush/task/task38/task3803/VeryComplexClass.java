package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = 1;
        String s = (String) o;
    }

    public void methodThrowsNullPointerException() {
        Object ob = null;
        ob.toString();
    }

    public static void main(String[] args) {
    }
}
