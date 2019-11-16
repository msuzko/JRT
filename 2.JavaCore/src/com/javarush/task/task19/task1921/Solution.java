package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedReader reader = new BufferedReader(new FileReader("/users/mec/test/4.txt"));

        while (reader.ready()){
            String s = reader.readLine();
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            m.find();
            int date = Integer.valueOf(m.group());
            m.find();
            int month = Integer.valueOf(m.group());
            m.find();
            int year = Integer.valueOf(m.group());
            p = Pattern.compile("\\D+");
            m = p.matcher(s);
            m.find();
            PEOPLE.add(new Person(m.group().trim(),new GregorianCalendar(year,month-1,date).getTime()));
        }
        System.out.println(PEOPLE);
        reader.close();
    }
}
