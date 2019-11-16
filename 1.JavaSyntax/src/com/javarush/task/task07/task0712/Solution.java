package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++)
            strings.add(reader.readLine());
        int min = strings.get(0).length();
        int max = strings.get(0).length();
        int indexMax =0,indexMin = 0;
        for (int i=1;i<strings.size();i++){
            int l = strings.get(i).length();
            if (l<min) {
                min = l;
                indexMin = i;
            }
            if (l>max) {
                max = l;
                indexMax = i;
            }
        }
        System.out.println(strings.get(indexMax>indexMin?indexMin:indexMax));
    }
}
