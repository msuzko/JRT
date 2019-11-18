package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        for (Cat cat :
                cats) {
            cats.remove(cat);
            break;
        }

        printCats(cats);

    }

    public static Set<Cat> createCats() {
        Set<Cat> catSet = new HashSet<>();
        catSet.add(new Cat());
        catSet.add(new Cat());
        catSet.add(new Cat());
        return catSet;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat :
                cats) {
            System.out.println(cat);
        }
    }

   public static class Cat{
       public Cat() {
       }
   }
}
