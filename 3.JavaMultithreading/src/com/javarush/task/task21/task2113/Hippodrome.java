package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i<10;i++)
            System.out.println();
    }

    public Horse getWinner(){
        Horse faster = horses.get(0);
        double maxDistance = faster.getDistance();
        for (Horse horse :
                horses) {
            if (horse.getDistance() > maxDistance){
                maxDistance = horse.getDistance();
                faster = horse;
            }
        }
        return faster;
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("Betty", 3, 0));
        list.add(new Horse("Vikky", 3, 0));
        list.add(new Horse("Sunny", 3, 0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();

    }
}
