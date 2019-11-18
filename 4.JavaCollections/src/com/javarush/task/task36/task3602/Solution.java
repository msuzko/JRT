package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clazz : Collections.class.getDeclaredClasses())
            if (Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers()))
                if (hasInterfaceList(clazz) && hasMethodGetThrowsIndexOutOfBoundsException(clazz))
                    return clazz;
        return null;
    }

    private static boolean hasMethodGetThrowsIndexOutOfBoundsException(Class clazz) {
        try {
            Constructor<?> constructor = getConstructor(clazz);
            Method methodGet = getMethodGet(clazz);
            methodGet.invoke(constructor.newInstance(), 1);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            if (e.getCause().getClass().getName().contains("IndexOutOfBoundsException"))
                return true;
        }
        return false;
    }

    private static Constructor<?> getConstructor(Class clazz) throws NoSuchMethodException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor;
    }

    private static Method getMethodGet(Class clazz) throws NoSuchMethodException {
        Method methodGet = clazz.getDeclaredMethod("get", int.class);
        methodGet.setAccessible(true);
        return methodGet;
    }

    private static boolean hasInterfaceList(Class clazz) {
        boolean isImplementsList = checkImplementsList(clazz.getInterfaces());
        if (isImplementsList)
            return true;
        Class<?> superClass = clazz.getSuperclass();
        while (superClass != null) {
            isImplementsList = checkImplementsList(superClass.getInterfaces());
            if (isImplementsList)
                return true;
            superClass = superClass.getSuperclass();
        }
        return false;

    }

    public static boolean checkImplementsList(Class<?>[] interfaces) {
        for (Class<?> interFace : interfaces)
            if (interFace.getSimpleName().equals("List"))
                return true;
        return false;
    }
}
