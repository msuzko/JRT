package com.javarush.task.task29.task2909.human;

<<<<<<< HEAD
public class Worker {
    private Human human;
    private double salary;
    public String company;

    public Worker(String name, int age) {
        human = new Human(name,age);
    }

    public void live() {
        human.live();
=======
public class Worker extends Human{
    private double salary;
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Worker(String name, int age){
        super(name,age);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public double getSalary() {
        return salary;
    }

<<<<<<< HEAD
    public void setSlr(double salary) {
=======
    public void setSalary(double salary) {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        this.salary = salary;
    }
}