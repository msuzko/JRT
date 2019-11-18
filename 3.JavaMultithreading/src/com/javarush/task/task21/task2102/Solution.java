package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

<<<<<<< HEAD
/* 
=======
/*
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
<<<<<<< HEAD
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        return (allModifiers&specificModifier)!=0;
=======
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {

        return (allModifiers & specificModifier) !=0;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
