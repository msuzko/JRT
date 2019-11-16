package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human ch1 = new Human("Vlad",true,11);
        Human ch2= new Human("Lera",false,10);
        Human ch3 = new Human("Ilya",true,6);

        ArrayList<Human> chidrenList = new ArrayList<>();
        chidrenList.add(ch1);
        chidrenList.add(ch2);
        chidrenList.add(ch3);

        Human fa = new Human("Misha",true,35,chidrenList);
        Human mo = new Human("Katsa", false,35, chidrenList);

        ArrayList<Human> chidrenMoList = new ArrayList<>();
        chidrenMoList.add(mo);

        ArrayList<Human> chidrenFaList = new ArrayList<>();
        chidrenFaList.add(fa);

        Human pa1 = new Human("Tolya",true,58,chidrenFaList);
        Human mo1 = new Human("Lena", false, 55, chidrenFaList);
        Human pa2 = new Human("Andrey",true,60,chidrenMoList);
        Human mo2 = new Human("Lyuda",false,60,chidrenMoList);

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(fa);
        System.out.println(mo);
        System.out.println(pa1);
        System.out.println(mo1);
        System.out.println(pa2);
        System.out.println(mo2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            children = new ArrayList<>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
