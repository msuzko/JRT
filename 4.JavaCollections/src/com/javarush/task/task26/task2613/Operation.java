package com.javarush.task.task26.task2613;

public enum Operation {
    INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {
        if (i < 1 || i > values().length)
            throw new IllegalArgumentException("Не верный аргумент");
        return values()[i-1];

    }
}
