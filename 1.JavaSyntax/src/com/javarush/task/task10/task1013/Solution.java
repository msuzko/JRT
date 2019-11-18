package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String lastName;
        private String name;
        private char sex;
        private byte age;
        private boolean hasChildren;
        private byte countChildren;

        public Human(String name) {
            this.name = name;
        }

        public Human(String lastName, String name) {
            this.lastName = lastName;
            this.name = name;
        }

        public Human(String lastName, String name, char sex) {
            this.lastName = lastName;
            this.name = name;
            this.sex = sex;
        }

        public Human(String lastName, String name, char sex, byte age) {
            this.lastName = lastName;
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String lastName, String name, char sex, byte age, boolean hasChildren) {
            this.lastName = lastName;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.hasChildren = hasChildren;
        }

        public Human(String lastName, String name, char sex, byte age, boolean hasChildren, byte countChildren) {
            this.lastName = lastName;
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.hasChildren = hasChildren;
            this.countChildren = countChildren;
        }

        public Human(String lastName, char sex, byte age) {
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, char sex, byte age, boolean hasChildren) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.hasChildren = hasChildren;
        }

        public Human(String name, char sex, byte age, boolean hasChildren, byte countChildren) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.hasChildren = hasChildren;
            this.countChildren = countChildren;
        }

        public Human(String name, char sex, boolean hasChildren, byte countChildren) {
            this.name = name;
            this.sex = sex;
            this.hasChildren = hasChildren;
            this.countChildren = countChildren;
        }
    }

}
