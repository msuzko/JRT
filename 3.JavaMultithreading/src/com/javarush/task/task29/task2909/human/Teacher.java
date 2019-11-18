package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class Teacher extends Human {
    private int numberOfStudents;
    private String university;
=======
public class Teacher extends UniversityPerson {
    private int numberOfStudents;

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public Teacher(String name, int age, int numberOfStudents) {
        super(name,age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

<<<<<<< HEAD
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void printData() {
        System.out.println("Преподаватель: " + name);
=======

    @Override
    public String getPosition() {
        return "Преподаватель";
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}