package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        YieldRunnable yieldRunnable1 = new YieldRunnable(1);
        YieldRunnable yieldRunnable2 = new YieldRunnable(2);
        YieldRunnable yieldRunnable3 = new YieldRunnable(3);
        Thread thread1 = new Thread(yieldRunnable1);
        Thread thread2 = new Thread(yieldRunnable2);
        Thread thread3 = new Thread(yieldRunnable3);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
