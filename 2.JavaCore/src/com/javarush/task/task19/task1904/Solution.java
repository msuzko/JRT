package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Calendar cld = Calendar.getInstance();

            String[] personData = fileScanner.nextLine().split(" ");
            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];
            cld.set(Integer.parseInt(personData[5]), Integer.parseInt(personData[4])-1, Integer.parseInt(personData[3]), 0, 0, 0);
            return new Person(firstName,middleName,lastName,cld.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
