package com.javarush.task.task29.task2909.user;

public class User {
    private String name;
    private String surname;
    private int age;

<<<<<<< HEAD
    private String country;
    private String city;
    private House house;
=======
    private boolean man = false;

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

<<<<<<< HEAD
=======
    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

<<<<<<< HEAD
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return country + " " + city + " " + house.house;
=======
    public String getAddress() {
        return getCountry() + " " + getCity() + " " + getHouse();
    }

    public String getCountry(){
        return address.getCountry();
    }

    public String getCity(){
        return address.getCity();
    }

    public String getHouse(){
        return address.getHouse();
    }

    public void setCountry(String country){
        address.setCountry(country);
    }

    public void setHouse(String house){
        address.setHouse(house);
    }

    public void setCity(String city){
        address.setCity(city);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
<<<<<<< HEAD
=======

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
    }

    public void printAdditionalInfo() {
        if (age < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getBoss(){
        return work.getBoss();
    }


>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}