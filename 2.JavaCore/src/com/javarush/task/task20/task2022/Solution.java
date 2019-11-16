package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("/users/mec/test/5.txt");
        solution.writeObject("Test1");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/users/mec/test/6.txt"));
        outputStream.writeObject(solution);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream((new FileInputStream("/users/mec/test/6.txt")));
        Solution loadedSolution = (Solution) inputStream.readObject();
        inputStream.close();
        loadedSolution.writeObject("Test2");

    }
}
