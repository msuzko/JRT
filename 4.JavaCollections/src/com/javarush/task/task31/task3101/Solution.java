package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
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

<<<<<<< HEAD
        Map<String, File> map = new TreeMap<>();
=======
         Map<String, File> map = new TreeMap<>();
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

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
<<<<<<< HEAD
=======
                // System.out.println(entry.getKey() + ": " + entry.getValue().getAbsolutePath());
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
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
<<<<<<< HEAD

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        public MyFileVisitor(Map<String, File> map) {
            this.map = map;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
            File file = path.toFile();
<<<<<<< HEAD
            if (!attrs.isDirectory() && attrs.size() <= 50 && file.getName().endsWith(".txt")) {
=======
            if (!attrs.isDirectory() && attrs.size()<=50 && file.getName().endsWith(".txt")) {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
                map.put(file.getName(), file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
