package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denomination > 0 && count > 0)
            if (denominations.containsKey(denomination))
                denominations.put(denomination, denominations.get(denomination) + count);
            else
                denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int amount = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
            amount += entry.getKey() * entry.getValue();
        return amount;
    }
}
