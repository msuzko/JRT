package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date start = new Date();
        for (String s : strings)
            ids.add(shortener.getId(s));
        return new Date().getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date start = new Date();
        for (Long id : ids)
            strings.add(shortener.getString(id));
        return new Date().getTime() - start.getTime();
    }

    public void testHashMapStorage(){
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener1 = new Shortener(hashMapStorageStrategy);
        Shortener shortener2 = new Shortener(hashBiMapStorageStrategy);
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for (int i = 0; i < 10000; i++)
            origStrings.add(Helper.generateRandomString());
        Assert.assertTrue(getTimeToGetIds(shortener1, origStrings, ids) > getTimeToGetIds(shortener2, origStrings, ids));
        Assert.assertEquals(getTimeToGetStrings(shortener1, ids, origStrings), getTimeToGetStrings(shortener2, ids, origStrings), 30);

    }

}
