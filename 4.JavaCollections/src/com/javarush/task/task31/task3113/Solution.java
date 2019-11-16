package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = reader.readLine();
        reader.close();
        Path path = Paths.get(pathStr);
        if (!Files.isDirectory(path)) {
            System.out.println(pathStr + " - не папка");
            return;
        } else {
            MyFileVisitor visitor = new MyFileVisitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.getCountDirs());
            System.out.println("Всего файлов - " + visitor.getCountFiles());
            System.out.println("Общий размер - " + visitor.getBytes());
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private int countFiles;
        private int countDirs = -1;
        private long bytes;

        public int getCountFiles() {
            return countFiles;
        }

        public int getCountDirs() {
            return countDirs;
        }

        public long getBytes() {
            return bytes;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            countFiles++;
            bytes += attrs.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            countDirs++;
            return FileVisitResult.CONTINUE;
        }
    }
}
