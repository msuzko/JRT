package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a;
        List<Integer> list = new ArrayList<>();
        while (true){
            try {
                a = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                break;
            } catch (NumberFormatException e){
                break;
            }
            list.add(a);
        }
        for (int i :
                list) {
            System.out.println(i);
        }
    }
}
