package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
//        String path = "C:\\temp";
//        String resultFileAbsolutePath = "C:\\111\\1.txt";
        File resultFile = new File(resultFileAbsolutePath);
        File newResultFile = new File(resultFile.getParent() + "\\allFilesContent.txt");
        if (FileUtils.isExist(resultFile))
            FileUtils.renameFile(resultFile, newResultFile);

        Map<String, File> map = new TreeMap<>();

        try {
            Files.walkFileTree(new File(path).toPath(), new MyFileVisitor(map));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(newResultFile, false);
            BufferedWriter out = new BufferedWriter(writer);
            for (Map.Entry<String, File> entry :
                    map.entrySet()) {
                try {
                    FileInputStream fis = new FileInputStream(entry.getValue());
                    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                    String line;
                    while ((line = in.readLine()) != null) {
                        out.write(line);
                    }
                    out.write("\n");
                    in.close();
                    fis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            out.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private Map<String, File> map;

        public MyFileVisitor(Map<String, File> map) {
            this.map = map;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            File file = path.toFile();
            if (!attrs.isDirectory() && attrs.size() <= 50 && file.getName().endsWith(".txt")) {
                map.put(file.getName(), file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
