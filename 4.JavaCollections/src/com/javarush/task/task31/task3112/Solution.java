package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        //Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/temp"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();

        Path tempFile = Files.createTempFile( "temp",".tmp");
        Files.copy(is, tempFile,REPLACE_EXISTING);

//        if (Files.notExists(downloadDirectory))
//            Files.createDirectories(downloadDirectory);

        int index = urlString.lastIndexOf("/");
        String name = urlString.substring(index);
        Path newFile = Paths.get(downloadDirectory.toString() + name);

            Files.move(tempFile, newFile,REPLACE_EXISTING );
       // Files.delete(tempDir);
        return newFile;
    }
}
