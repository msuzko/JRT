package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> ar = new ArrayList<>();
        ArrayList<Thread> list = new ArrayList<>();
        int lo = String.valueOf(N).length();
        long[][] pow = new long[10][lo + 1];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j <= lo; j++) {
                pow[i][j] = (long) Math.pow(i, j);
            }

        long[] pow10 = new long[lo + 1];
        for (int i = 0; i <= lo; i++)
            pow10[i] = (long) Math.pow(10, i);

        long num = 0;
        boolean stop = false;
        for (int j = 0; j < 10 && stop == false; j++)
            for (int k = j; k < 10 && stop == false; k++)
                for (int a = k; a < 10; a++) {
                    num = j * pow10[2] + k * pow10[1] + a * pow10[0];
                    if (num > N) {
                        stop = true;
                        break;
                    }
                    chek(num, ar, pow, N);
                }

//        long part = N / 4;
//        long l = 1;
//        for (int i = 0; i < 4; i++) {
//            Thread thread = new Thread(new Numbers(l, l + part, ar, pow));
//            thread.start();
//            l += part;
//            list.add(thread);
//        }
//
//        for (Thread thread : list) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }

        Collections.sort(ar);

        long[] result = new long[ar.size()];
        int i = 0;
        for (long ll :
                ar) {
            result[i++] = ll;
            System.out.println(ll);
        }


        return result;
    }

    private static ArrayList<Byte> getNums(long i) {
        ArrayList<Byte> list = new ArrayList();
        while (i > 0) {
            list.add((byte) (i % 10));
            i /= 10;
        }
        return list;
    }

    private static void chek(long i, ArrayList<Long> ar, long[][] pow, long n) {
        ArrayList<Byte> bytes = getNums(i);
        long sum = 0;
        for (byte str : bytes)
            sum += pow[str][bytes.size()];//(long)Math. pow(str, bytes.size());
        if (sum <= n)
            chekArm(sum, ar, pow);
    }

    private static void chekArm(long i, ArrayList<Long> ar, long[][] pow) {
        ArrayList<Byte> bytes = getNums(i);
        long sum = 0;
        for (byte str : bytes)
            sum += pow[str][bytes.size()];//(long)Math. pow(str, bytes.size());

        if (sum == i)
            synchronized (ar) {
                ar.add(sum);
            }
    }

    public static class Numbers implements Runnable {
        private long start, end;
        public static ArrayList<Long> ar;
        long[][] pow;

        public Numbers(long start, long end, ArrayList<Long> ar, long[][] pow) {
            this.start = start;
            this.end = end;
            this.ar = ar;
            this.pow = pow;
        }

        @Override
        public void run() {
            long sum;
            for (long i = start; i <= end; i++) {
                sum = 0L;
                ArrayList<Byte> bytes = getNums(i);
                for (byte str : bytes)
                    sum += pow[str][bytes.size()];//(long)Math. pow(str, bytes.size());

                if (sum == i)
                    synchronized (ar) {
                        ar.add(sum);
                    }

            }
        }
    }

    public static void main(String[] args) {
//        long freeMemory = Runtime.getRuntime().freeMemory();
//        long startTime = System.currentTimeMillis();
        getNumbers(999);
//        //System.out.println((new Date().getTime() - start) / 1000);
//        long memoryAfterCalculate = Runtime.getRuntime().freeMemory();
//        long delta = memoryAfterCalculate - freeMemory;
//        long stopTime = System.currentTimeMillis();
//        System.out.println("Calculating time: " + (stopTime - startTime));
//        System.out.println("Used JVM memory: " + delta);
    }
}
