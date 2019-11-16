package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        char[] chars = str.replace(" ","").toCharArray();
        List<Character> vowels = new ArrayList<>();
        List<Character> notVowels = new ArrayList<>();

        for (char ch :
                chars) {
            if (isVowel(ch))
                vowels.add(ch);
            else
                notVowels.add(ch);
        }
        for (Character ch :
                vowels) {
            System.out.print(ch+" ");
        }
        System.out.println();
        for (Character ch :
                notVowels) {
            System.out.print(ch+ " ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}