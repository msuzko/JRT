package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
public class Student extends Human {
    private double averageGrade;
    private String university;
    private Date beginningOfSession;
    private Date endOfSession;
=======
public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.averageGrade = averageGrade;
    }
<<<<<<< HEAD
=======
    public int getCourse() {
        return course;
    }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0


    public void live() {
        learn();
    }

    public void learn() {
    }

<<<<<<< HEAD
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Студент: " + name);
    }

    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
=======

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade()+delta);
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public double getAverageGrade() {
        return averageGrade;
    }
<<<<<<< HEAD
=======

    @Override
    public String getPosition() {
        return "Студент";
    }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}