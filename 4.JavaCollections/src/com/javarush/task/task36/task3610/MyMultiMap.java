package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> list : map.values())
            size += list.size();
        return size;
    }

    @Override
    public V put(K key, V value) {
        V lastAddedItem = null;
        if (map.containsKey(key)) {
            lastAddedItem = map.get(key).get(map.get(key).size() - 1);
            if (map.get(key).size() < repeatCount)
                map.get(key).add(value);
            else {
                map.get(key).remove(0);
                map.get(key).add(value);
            }
        } else {
            map.put(key, new ArrayList<>());
            map.get(key).add(value);
        }
        return lastAddedItem;
    }

    @Override
    public V remove(Object key) {
        V removedItem = null;
        if (map.containsKey(key)) {
            if (map.get(key).size() != 0)
                removedItem = map.get(key).remove(0);
            if (map.get(key).size() == 0)
                map.remove(key);
        }
        return removedItem;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (List<V> list : map.values())
            values.addAll(list);
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}