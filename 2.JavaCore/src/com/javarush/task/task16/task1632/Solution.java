package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static void main(String[] args) {
    }

    public static class MyThread1 extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
            }
        }
    }

    public static class MyThread2 extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
            }
            System.out.println("InterruptedException");
        }
    }

    public static class MyThread3 extends Thread {

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyThread4 extends Thread implements Message {
        boolean stop = false;

        @Override
        public void showWarning() {
            stop = true;
        }

        @Override
        public void run() {
            super.run();
            while (!stop) {
            }
        }
    }

    public static class MyThread5 extends Thread {

        @Override
        public void run() {
            super.run();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            try {
                while (true) {
                    String s = reader.readLine();
                    if ("N".equals(s)) {
                        break;
                    }
                    sum += Integer.parseInt(s);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sum);

        }
    }
}