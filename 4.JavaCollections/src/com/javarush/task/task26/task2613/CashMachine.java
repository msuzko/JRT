package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        System.out.println(ConsoleHelper.askOperation());
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] den = ConsoleHelper.getValidTwoDigits(currencyCode);
        currencyManipulator.addAmount(Integer.parseInt(den[0]), Integer.parseInt(den[1]));
        System.out.println(currencyManipulator.getTotalAmount());
    }
}
