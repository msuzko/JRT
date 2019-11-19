package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;
import com.javarush.task.task33.task3310.tests.FunctionalTest;
import com.javarush.task.task33.task3310.tests.SpeedTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),100);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);
        FunctionalTest testF = new FunctionalTest();
        testF.testDualHashBidiMapStorageStrategy();
        testF.testOurHashBiMapStorageStrategy();
        testF.testOurHashMapStorageStrategy();
        testF.testHashBiMapStorageStrategy();
        testF.testHashMapStorageStrategy();
        testF.testFileStorageStrategy();
        SpeedTest testS = new SpeedTest();
        testS.testHashMapStorage();
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String str : strings)
            ids.add(shortener.getId(str));
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long i : keys)
            strings.add(shortener.getString(i));
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> startStrings = createTempSet(elementsNumber);
        Shortener shortener = new Shortener(strategy);

        Set<Long> ids = getIdsTest(startStrings, shortener);

        Set<String> finishStrings = getStringsTest(ids, shortener);

        if (startStrings.containsAll(finishStrings))
            Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    private static Set<String> getStringsTest(Set<Long> ids, Shortener shortener) {
        Set<String> strings;
        Date start = new Date();
        strings = getStrings(shortener, ids);
        Helper.printMessage(String.valueOf(new Date().getTime() - start.getTime()));
        return strings;
    }

    private static Set<Long> getIdsTest(Set<String> testStrings, Shortener shortener) {
        Set<Long> ids;
        Date start = new Date();
        ids = getIds(shortener, testStrings);
        Helper.printMessage(String.valueOf(new Date().getTime() - start.getTime()));
        return ids;
    }

    private static Set<String> createTempSet(long elementsNumber) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            strings.add(Helper.generateRandomString());
        return strings;
    }
}
