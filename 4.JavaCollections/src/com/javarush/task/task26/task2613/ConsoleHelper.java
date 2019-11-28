package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return bis.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static String askCurrencyCode() {
        String currencyCode;
        while (true) {
            writeMessage("Введите код валюты:");
            currencyCode = readString();
            if (currencyCode.length() == 3)
                return currencyCode.toUpperCase();
            writeMessage("Вы ввели некорректный код!");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        writeMessage(String.format("Введите номинал и количество банкнот для валюты %s:", currencyCode));
        String input = readString();
        if (input.matches("^[1-9]\\d* [1-9]\\d*$"))
            return input.split(" ");
        else
            writeMessage("Введено некорректное число!");
        return getValidTwoDigits(currencyCode);
    }

    public static Operation askOperation() {
        ConsoleHelper.writeMessage("Выберите операцию");
        int i = 1;
        for (Operation operation : Operation.values())
            ConsoleHelper.writeMessage(String.format("%d. %s", i++, operation.name()));

        int operation = Integer.parseInt(readString());
        try {
            return Operation.getAllowableOperationByOrdinal(operation);
        } catch (IllegalArgumentException e) {
            return askOperation();
        }
    }
}
