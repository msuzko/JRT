package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public static void main(String[] args) {
        new Solution().recurse(132);

    }

    public void recurse(int n) {
        if (n<=1) return;
        for (int i = 2; i < n; i++) {
            boolean isSimple = true;
            for (int j = 3; j < i; j++)
                if (i % j == 0)
                    isSimple = false;
            if (isSimple && n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                return;
            }
        }
        System.out.print(n);

    }
}
