package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    private static final int FIELD_WIDTH = 4;

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());

        game.setLocationRelativeTo(null);
        game.setVisible(true);
//        Main main = new Main();
//        Model model = new Model();
//        Tile[][] tiles = model.getGameTiles();
//        tiles[0] = new Tile[]{new Tile(4),new Tile(2),new Tile(4),new Tile(8)};
//        tiles[1] = new Tile[]{new Tile(2),new Tile(2),new Tile(0),new Tile(2)};
//        tiles[2] = new Tile[]{new Tile(2),new Tile(2),new Tile(0),new Tile(2)};
//        tiles[3] = new Tile[]{new Tile(4),new Tile(2),new Tile(2),new Tile(4)};
//        model.down();
//        System.out.println(Arrays.asList(model.getGameTiles()[0]));
//        System.out.println(Arrays.asList(model.getGameTiles()[1]));
//        System.out.println(Arrays.asList(model.getGameTiles()[2]));
//        System.out.println(Arrays.asList(model.getGameTiles()[3]));
    }





}
