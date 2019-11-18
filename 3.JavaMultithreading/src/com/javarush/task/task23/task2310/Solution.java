package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    protected String getName() {
=======
    public String getName() {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
<<<<<<< HEAD
                System.out.println(getName());
=======
                System.out.println(this.getName());
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
