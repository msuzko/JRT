package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Movie movie;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            movie = MovieFactory.getMovie(reader.readLine());
            if (movie== null) break;
            System.out.println(movie.getClass().getSimpleName());
        }

        reader.close();
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie  {
    }
    static class Thriller extends Movie  {
    }
    //Напишите тут ваши классы, пункт 3
}
