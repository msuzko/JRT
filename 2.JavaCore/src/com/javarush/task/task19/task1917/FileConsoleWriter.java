package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.print(new String(cbuf).substring(off, off + len));
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(new String(cbuf));
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {
//        FileConsoleWriter writer = new FileConsoleWriter(new FileWriter("/users/mec/test/5.txt"));
//        String s = "Мама мыла раму";
//        writer.write('a');
//        writer.write(s,0,6);
//        writer.close();
    }

}
