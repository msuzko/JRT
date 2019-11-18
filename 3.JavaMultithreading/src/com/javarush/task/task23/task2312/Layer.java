package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getMouse().getX()*10, Room.game.getMouse().getY()*10, 10, 10); //Рисуем прямоугольник показывающий мышь


        //g.fillRect(Room.game.castToHasWidth() * 10, 0, 10, (Room.game.castToHasWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        //g.fillRect(0, Room.game.castToHasHeight() * 10, (Room.game.castToHasHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу


        ArrayList<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки

        g.setColor(Color.RED); //Задаем цвет элементов зеленый
        g.fillRect(getsection.get(0).getX()*10, getsection.get(0).getY()*10, 10, 10); //Рисуем по очереди секции змейки

        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        for (int i = 1; i < getsection.size(); i++) {
            g.fillRect(getsection.get(i).getX()*10, getsection.get(i).getY()*10, 10, 10); //Рисуем по очереди секции змейки
        }
    }

}
