package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream stream;

    public AmigoOutputStream(FileOutputStream out) throws FileNotFoundException {
        super(fileName);
        stream = out;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void close() throws IOException {
        stream.flush();
        stream.write("JavaRush © All rights reserved.".getBytes());
        stream.close();
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }
}
