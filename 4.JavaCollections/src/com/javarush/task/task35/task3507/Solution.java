package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        File[] files = new File(pathToAnimals).listFiles();
        assert files != null;
        for (File file : files) {
            checkFileAndCreateAnimalAndPutToSet(animals, file);
        }
        return animals;
    }

    private static void checkFileAndCreateAnimalAndPutToSet(Set<Animal> animals, File file) {
        if (file.isFile() && file.getName().endsWith(".class")) {
            Class clazz = getAClass(file);
            boolean isAnimal = checkClassImplementAnimal(clazz);
            boolean isTherePublicConstructor = checkClassHasPublicConstructor(clazz);

            if (isAnimal && isTherePublicConstructor) {
                createAndAddToSetAnimal(animals, clazz);
            }
        }
    }

    private static Class getAClass(File file) {
        String packageName = Solution.class.getPackage().getName() + ".data";
        return new ClassFromPath().load(file.toPath(), packageName);
    }

    private static void createAndAddToSetAnimal(Set<Animal> animals, Class clazz) {
        try {
            Animal animal = (Animal) clazz.newInstance();
            animals.add(animal);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkClassHasPublicConstructor(Class clazz) {
        for (Constructor constructor : clazz.getConstructors())
            if (constructor.getParameterCount() == 0)
                return true;
        return false;
    }

    private static boolean checkClassImplementAnimal(Class clazz) {
        for (Class interFace : clazz.getInterfaces())
            if (interFace.getSimpleName().equals("Animal"))
                return true;
        return false;
    }

    public static class ClassFromPath extends ClassLoader {
        Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
