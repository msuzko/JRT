package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;


    public Field(View view) {
        this.view = view;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        new Box(20,40).draw(g);
        new Player(40,70).draw(g);
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
}
