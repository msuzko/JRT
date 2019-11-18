package com.javarush.task.task21.task2112;

public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
<<<<<<< HEAD
            System.out.println("Entering body of try block.");
=======
            System.out.println("Entering the body of try block.");
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
        }
    }
}
