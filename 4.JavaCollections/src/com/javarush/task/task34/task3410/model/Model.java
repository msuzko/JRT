package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(new File(getClass().getResource("../res/levels.txt").getFile()).toPath());

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction) || checkBoxCollisionAndMoveIfAvaliable(direction)) return;
        move(player, direction);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction))
                return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        for (Box box : gameObjects.getBoxes())
            if (gameObjects.getPlayer().isCollision(box, direction)) {
                if (checkWallCollision(box, direction))
                    return true;
                for (Box box2 : gameObjects.getBoxes())
                    if (box.isCollision(box2, direction))
                        return true;
                move(box, direction);
                break;
            }
        return false;
    }

    private void move(Movable object, Direction direction) {
        switch (direction) {
            case LEFT:
                object.move(-FIELD_CELL_SIZE, 0);
                break;
            case RIGHT:
                object.move(FIELD_CELL_SIZE, 0);
                break;
            case UP:
                object.move(0, -FIELD_CELL_SIZE);
                break;
            case DOWN:
                object.move(0, FIELD_CELL_SIZE);
        }
    }

    public void checkCompletion() {
        for (Home home : gameObjects.getHomes()) {
            if (!homeHasBox(home))
                return;
        }
        eventListener.levelCompleted(currentLevel);
    }

    private boolean homeHasBox(Home home) {
        for (Box box : gameObjects.getBoxes())
            if (box.getX() == home.getX() && box.getY() == home.getY())
                return true;
        return false;
    }

}
