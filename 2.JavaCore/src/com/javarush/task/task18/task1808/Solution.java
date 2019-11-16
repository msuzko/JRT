package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
//            file1="/users/mec/test/task1808.txt";
//            file2="/users/mec/test/task1808_2.txt";
//            file3="/users/mec/test/task1808_3.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(new File(reader.readLine()));
        FileOutputStream outputStream2 = new FileOutputStream(new File(reader.readLine()));
        FileOutputStream outputStream3 = new FileOutputStream(new File(reader.readLine()));
        reader.close();

        if (is.available()>0){
            int size = is.available();
            int size3 = size/2;
            int size2 = size-size3;
            byte[] buffer2 = new byte[size2];
            byte[] buffer3 = new byte[size3];
            int count2 = is.read(buffer2);
            int count3 = is.read(buffer3);
            outputStream2.write(buffer2,0,count2);
            outputStream3.write(buffer3,0,count3);
        }

        is.close();
        outputStream2.close();
        outputStream3.close();
    }
}
