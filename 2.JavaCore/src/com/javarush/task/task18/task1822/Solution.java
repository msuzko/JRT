package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        String id = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine())!=null){
            if(line.startsWith(id+ " ")){
                System.out.println(line);
                break;
            }
        }

        reader.close();
    }
}
