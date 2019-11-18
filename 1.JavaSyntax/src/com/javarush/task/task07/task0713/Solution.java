package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listDop1 = new ArrayList<>();
        ArrayList<Integer> listDop2 = new ArrayList<>();
        ArrayList<Integer> listDop3 = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        String s;
        while (i<20) {
            s = reader.readLine();
            if (s.isEmpty())
                continue;
            list.add(Integer.parseInt(s));
            i++;
        }
        boolean yes;
        for (int j:
             list) {
            yes = false;
            if (j % 3 == 0) {
                listDop1.add(j);
                yes = true;
            }
            if (j % 2 == 0) {
                listDop2.add(j);
                yes = true;
            }
            if (!yes)
                listDop3.add(j);
        }
        printList(listDop1);
        printList(listDop2);
        printList(listDop3);

    }

    public static void printList(List<Integer> list) {
        for (int i :
                list) {
            System.out.println(i);
        }
    }
}
