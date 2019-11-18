package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Files.walkFileTree(new File(root).toPath(),new MyFileVisitor(list));
        return list;

    }

    public static void main(String[] args) throws IOException {
<<<<<<< HEAD
=======
//        for (String s :
////                getFileTree("C:\\temp")) {
////            System.out.println(s);
////        }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
    
    private static class MyFileVisitor extends SimpleFileVisitor<Path>{
        List<String> list;

        public MyFileVisitor(List<String> list) {
            this.list = list;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            list.add(file.toFile().getAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }
}
