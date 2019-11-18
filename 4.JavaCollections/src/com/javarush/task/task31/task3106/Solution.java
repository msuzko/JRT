package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.TreeSet;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
<<<<<<< HEAD
=======
        //String resultFileName = args[0];
        //String resultFileName = "C:\\temp\\song.mp3";
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        //Заполним сет именами архивов
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            String name = args[i];
<<<<<<< HEAD
=======
            //String name = "C:\\temp\\test.zip.00" + i;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
            set.add(name);
        }
        //Соберем вектор из этих имен
        Vector<InputStream> vector = new Vector<>();
        for (String n : set)
            vector.add(new FileInputStream(n));
        //Создаем поток чтения архивов на основе вектора значений
        try (ZipInputStream zipReader = new ZipInputStream(new SequenceInputStream(vector.elements()))) {
            try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(args[0]))) {
                //считываем фйалы в буфер
                while (zipReader.getNextEntry() != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zipReader.read(buffer)) != -1)
                        byteArrayOutputStream.write(buffer, 0, count);
                    //записываем данные из буфера в поток
                    writer.write(byteArrayOutputStream.toByteArray());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
