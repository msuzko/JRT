package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution savedObject = new Solution(4);
        System.out.println(savedObject);
        FileOutputStream fileOutputStream = new FileOutputStream("/users/mec/test/6.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(savedObject);
        fileOutputStream.close();
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("/users/mec/test/6.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution loadedObject = (Solution)inputStream.readObject();
        fileInputStream.close();
        inputStream.close();
        System.out.println(loadedObject);
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}