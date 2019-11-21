package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] symbols = s.toUpperCase().toCharArray();
        int number = 0;
        int last = 0;
        for (int i=symbols.length-1; i>=0; i--){
            int n = getIntegerNumberFromRoman(symbols[i]);
            number = processDecimal(n, last, number);
            last = n;
        }
        return number;
    }

    private static int getIntegerNumberFromRoman(char symbol) {
        switch (symbol){
            case 73: return 1;      //I
            case 86: return 5;      //V
            case 88: return 10;     //X
            case 76: return 50;     //L
            case 67: return 100;    //C
            case 68: return 500;    //D
            case 77: return 1000;   //M
            default: return 0;
        }
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

}
