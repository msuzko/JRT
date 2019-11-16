package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    private List<Entry<String>> list = new ArrayList<>();
    private Map<Integer,List<Entry<String>>> map = new HashMap<>();

    public CustomTree() {
        this.root = new Entry<>("0");
        this.list.add(this.root);
        List<Entry<String>> listLevel = new ArrayList<>();
        listLevel.add(root);
        this.map.put(0, listLevel);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> entry = new Entry<>(elementName);
        for (Entry<String> en : list)
            if (addEntry(en, entry))
                return true;
        int level = getLevel(list.get(list.size()-1));
        for (Entry en : map.get(level)){
            if (en.rightChild == null)
                en.availableToAddRightChildren = true;
            if (en.leftChild == null)
                en.availableToAddLeftChildren = true;
        }
        return add(elementName);
    }

    private boolean addEntry(Entry<String> rootEntry, Entry<String> newEntry) {
        if (rootEntry.isAvailableToAddChildren()) {
            if (rootEntry.availableToAddLeftChildren) {
                rootEntry.leftChild = newEntry;
                rootEntry.availableToAddLeftChildren = false;
            } else {
                rootEntry.rightChild = newEntry;
                rootEntry.availableToAddRightChildren = false;
            }
            newEntry.parent = rootEntry;
            list.add(newEntry);
            int level = getLevel(newEntry);
            if (map.containsKey(level)){
                List<Entry<String>> l = map.get(level);
                l.add(newEntry);
            } else{
                List<Entry<String>> l = new ArrayList<>();
                l.add(newEntry);
                map.put(level,l);
            }
            return true;
        } else
            return false;
    }

    public String getParent(String s) {
        for (Entry<String> entry :
                list) {
            if (entry.elementName.equals(s))
                if (entry.parent == null)
                    return null;
                else
                    return entry.parent.elementName;
        }
        return null;
    }

    private int getLevel(Entry<String> entry){
        int count = 0;
        Entry<String> currentEntry = entry;
        while (currentEntry.parent!=null){
            count++;
            currentEntry = currentEntry.parent;
        }
        return count;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String))
            throw new UnsupportedOperationException();
        String s = (String) o;
        for (Entry<String> entry : list) {
            if (entry.elementName.equals(s)){
                removeEntry(entry);
                return true;
            }

        }
        return false;
    }

    private void removeEntry(Entry<String> entry) {
        if (entry.rightChild!=null){
            removeEntry(entry.rightChild);
        }
        if (entry.leftChild!=null){
            removeEntry(entry.leftChild);
        }
        if (entry.parent.leftChild == entry)
            entry.parent.leftChild = null;
        else if (entry.parent.rightChild == entry)
            entry.parent.rightChild = null;
        list.remove(entry);
        map.get(getLevel(entry)).remove(entry);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

}
