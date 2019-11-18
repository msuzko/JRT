package com.javarush.task.task25.task2513;

import java.util.Random;

/* 
Обеспечение отсутствия прерывания важной операции
*/
public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        from.setBalance(from.getBalance() - amount);
        if (RANDOM.nextInt(5000)>THRESHOLD_VALUE)
            Thread.yield();
        to.setBalance(to.getBalance() + amount);
    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Account account1 = solution.new Account();
        Account account2 = solution.new Account();
        account1.setBalance(1000);
        account2.setBalance(2000);
        solution.moveMoney(account1,account2,100);
        solution.moveMoney(account1,account2,200);
        solution.moveMoney(account2,account1,400);
        solution.moveMoney(account2,account1,100);
        solution.moveMoney(account1,account2,100);
        solution.moveMoney(account2,account1,100);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}
