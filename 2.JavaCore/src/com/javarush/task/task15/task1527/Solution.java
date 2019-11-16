package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String objVal = null;
        if (url.contains("?")){
            String[] params;
            String delimeter = "&"; // Разделитель
            params = url.substring(url.indexOf("?")+1).split(delimeter);
            for (String substr :
                    params) {
                if (substr.contains("=")) {//есть значение
                    String[] paramVal;
                    paramVal = substr.split("=");
                    System.out.print(paramVal[0] + " ");
                    if (paramVal[0].equals("obj"))
                        objVal = paramVal[1];
                } else System.out.print(substr + " ");
            }
            System.out.println();
        }
        if (objVal!=null){
            try {
                alert(Double.parseDouble(objVal));
            } catch (Exception e){
                alert(objVal);
            }
        }

        reader.close();
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
