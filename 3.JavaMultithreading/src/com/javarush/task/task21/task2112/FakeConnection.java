package com.javarush.task.task21.task2112;

public class FakeConnection implements AutoCloseable{

    public FakeConnection() {
<<<<<<< HEAD
        System.out.println("Establishing database connection...");
=======
        System.out.println("Creating database connection...");
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing database connection...");
    }
}
