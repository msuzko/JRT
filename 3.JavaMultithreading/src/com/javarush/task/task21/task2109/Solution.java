package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

<<<<<<< HEAD
        public String getName() {
            return name;
        }

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
<<<<<<< HEAD
=======

        public String getName() {
            return name;
        }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
<<<<<<< HEAD
            C c  = new C(getI(),getJ(),getName());
            return c;
=======
            return new C(getI(),getJ(),getName());
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        }
    }

    public static void main(String[] args) {

    }
}
