package com.javarush.task.task29.task2909.human;

<<<<<<< HEAD
public class University extends Student {

    public University(String name, int age) {
        super(name, age, 0);
    }

    public Student getStudentWithAverageGrade() {
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade(double averageGrade) {
        //TODO:
        return null;
    }

    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
=======
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student :
                students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentMax = students.get(0);
        double max = studentMax.getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() > max) {
                max = student.getAverageGrade();
                studentMax = student;
            }
        }
        return studentMax;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentMin = students.get(0);
        double min = studentMin.getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() < min) {
                min = student.getAverageGrade();
                studentMin = student;
            }
        }
        return studentMin;
    }

    public void expel(Student student) {
        students.remove(student);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}