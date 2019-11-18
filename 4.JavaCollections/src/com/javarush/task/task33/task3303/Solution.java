package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
<<<<<<< HEAD
=======

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        return mapper.readValue(new FileReader(fileName),clazz);
    }

    public static void main(String[] args) {

    }
}
