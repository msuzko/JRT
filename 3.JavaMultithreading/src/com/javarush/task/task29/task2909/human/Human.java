package com.javarush.task.task29.task2909.human;

<<<<<<< HEAD
=======

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

<<<<<<< HEAD
public class Human {
    public static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected int course;
    private List<Human> children = new ArrayList<>();


    protected int[] size;


    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private int bloodGroup;

    public void setBloodGroup(int code) {
        bloodGroup = code;
    }

    public int getBloodGroup() {
        return bloodGroup;
=======
public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();


    protected Size size;


    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human) {
        this.children.add(human);
    }

    public void removeChild(Human human) {
        this.children.remove(human);
    }


    public Human(String name,int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public int getCourse() {
        return course;
    }
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public void live() {
    }
    public int getId() {
        return id;
    }

<<<<<<< HEAD
    public void setId(int id) {
        this.id = id;
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
=======
    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    public class Size{
        public int height,weight;
    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}