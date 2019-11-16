package com.javarush.task.task09.task0924;

import java.util.ArrayList;

/* 
Страшная сказка
*/

public class Solution {
    public static LittleRedRidingHood hood = new LittleRedRidingHood();
    public static Grandmother grandmother = new Grandmother();
    public static Patty patty = new Patty();
    public static Woodman woodman = new Woodman();
    public static Wolf wolf = new Wolf();

    public static void main(String[] args) {
        wolf.ate(grandmother);
        wolf.ate(hood);
        woodman.kill(wolf);

    }

    //красная шапочка
    public static class LittleRedRidingHood extends StoryItem {
    }

    //бабушка
    public static class Grandmother extends StoryItem {
    }

    //пирожек
    public static class Patty extends StoryItem {
    }

    //дровосек
    public static class Woodman extends StoryItem {
        public void kill(StoryItem item){
            killed.add(item);
        }
    }

    //волк
    public static class Wolf extends StoryItem {
        public void ate(StoryItem item){
            ate.add(item);
        }
    }

    public static abstract class StoryItem {
        public ArrayList<StoryItem> killed = new ArrayList<StoryItem>();
        public ArrayList<StoryItem> ate = new ArrayList<StoryItem>();
    }
}
