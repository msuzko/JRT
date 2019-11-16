package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3)
                        addPeople(args[i], args[i + 1], args[i + 2]);
                }
                break;
            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4)
                        updatePeople(args[i], args[i + 1], args[i + 2], args[i + 3]);
                }
                break;
            case ("-d"):
                synchronized (allPeople) {
                    deletePeople(args);
                }
                break;
            case ("-i"):
                synchronized (allPeople) {
                    infoPeople(args);
                }

        }
    }

    private static void infoPeople(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i++) {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            String sex = p.getSex() == Sex.MALE ? "м" : "ж";
            System.out.println(p.getName() + " " + sex + " " + format.format(p.getBirthDay()));
        }

    }

    private static void deletePeople(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person p = allPeople.get(Integer.parseInt(args[i]));
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        }
    }

    private static void updatePeople(String id, String name, String sex, String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(dateStr);
        Person p = allPeople.get(Integer.parseInt(id));
        p.setName(name);
        if (sex.equals("м"))
            p.setSex(Sex.MALE);
        else
            p.setSex(Sex.FEMALE);
        p.setBirthDay(date);
    }

    private static void addPeople(String name, String sex, String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(dateStr);
        if (sex.equals("м"))
            allPeople.add(Person.createMale(name, date));
        else
            allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size() - 1);
    }

}
