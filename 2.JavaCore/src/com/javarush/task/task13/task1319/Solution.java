package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код /users/mec/test/my-object-data.txt
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        while (true) {
            String text = reader.readLine();
            writer.write(text + "\n");
            writer.flush();
            if (text.equals("exit"))
                break;
        }
        writer.close();
        reader.close();
    }
}
