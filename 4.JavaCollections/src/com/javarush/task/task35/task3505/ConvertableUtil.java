package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>>Map<K, V> convert(List<? extends Convertable<K>> list) {
        Map result = new HashMap();
        for (Convertable<K> c:list)
            result.put(c.getKey(),c);
        return result;
    }
}
