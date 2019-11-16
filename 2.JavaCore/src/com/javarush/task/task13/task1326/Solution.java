package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

//        InputStream inStream = new FileInputStream(name);//"/users/mec/test/my-object-data.txt");
//        ArrayList<Integer> list = new ArrayList<>();
//        while (inStream.available() > 0) {
//            Integer data = inStream.read(); //читаем один int из потока для чтения
//            if (data % 2 == 0)
//                list.add(data);
//        }

        Scanner scanner = new Scanner(new FileInputStream(name));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp % 2 == 0) {
                arrayList.add(temp);
            }
        }
        scanner.close();

        //inStream.close();//закрываем потоки
        Collections.sort(arrayList);
        for (int a :
                arrayList) {
            System.out.println(a);
        }
    }
}
