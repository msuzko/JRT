package com.javarush.task.task08.task0812;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<10;i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int max = 1;
        int cur = 1;
        for (int i=1;i<10;i++){
            if (list.get(i).intValue()==list.get(i-1).intValue())
                cur++;
            else{
                if(max<cur)
                    max = cur;
                cur=1;
            }
        }
        if(max<cur)
            max = cur;
        System.out.println(max);
    }
}