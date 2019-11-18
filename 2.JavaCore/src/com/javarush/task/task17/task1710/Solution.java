package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length==0) return;

        if (args[0].equals("-c")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(args[3]);
            if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1], date));
            else
                allPeople.add(Person.createFemale(args[1], date));
            System.out.println(allPeople.size()-1);
        } else if (args[0].equals("-u")) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(args[4]);
            Person p = allPeople.get(Integer.parseInt(args[1]));
            p.setName(args[2]);
            if (args[3].equals("м"))
                p.setSex(Sex.MALE);
            else
                p.setSex(Sex.FEMALE);
            p.setBirthDay(date);
        } else if (args[0].equals("-d")) {
            Person p = allPeople.get(Integer.parseInt(args[1]));
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        } else if (args[0].equals("-i")) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            Person p = allPeople.get(Integer.parseInt(args[1]));
            String sex = p.getSex()==Sex.MALE?"м":"ж";
            System.out.println(p.getName()+" "+ sex+" "+ format.format(p.getBirthDay()));

        }
    }
}
