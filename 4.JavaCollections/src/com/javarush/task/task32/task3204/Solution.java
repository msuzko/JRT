package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.*;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        List<Types> list = new ArrayList<>();
        int countDigits = 1+new Random().nextInt(8-2);
        int countLowerCase = 1+new Random().nextInt(8-countDigits-1);
        int countUpperCase = 8-countDigits - countLowerCase;
        list.add(new Types(TypesEn.Digits, countDigits));
        list.add(new Types(TypesEn.LowerCase, countLowerCase));
        list.add(new Types(TypesEn.UpperCase, countUpperCase));


        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        for (int i = 0; i<8; i++)
            stream.write(getNextSymbol(list));
            //System.out.println(getNextSymbol(list));
        return stream;
    }

    private static int getNextSymbol(List<Types> list) {

        Types t = list.get(new Random().nextInt(list.size()));
        int d = 0;
        if (t.type == TypesEn.Digits)
            d = getDigit();
         else if (t.type == TypesEn.LowerCase)
             d = getLowerCase();
         else if (t.type == TypesEn.UpperCase)
            d = getUpperCase();

         if (t.decreaseValue() == 0)
            list.remove(t);
        return d;
    }

    private static int getDigit() {
        return 48+new Random().nextInt(10);
    }

    private static int getUpperCase() {
        return 65+new Random().nextInt(26);
    }

    private static int getLowerCase() {
        return 97+new Random().nextInt(26);
    }

    private static class Types{
        TypesEn type;
        int value;

        public Types(TypesEn type, int value) {
            this.type = type;
            this.value = value;
        }

        int decreaseValue(){
            return --value;
        }
    }

}