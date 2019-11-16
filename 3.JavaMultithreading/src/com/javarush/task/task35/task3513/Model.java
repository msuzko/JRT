package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile();
        addTile();
        addTile();
        score = 0;
        maxTile = 0;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                if (gameTiles[i][j].isEmpty())
                    emptyTiles.add(gameTiles[i][j]);
        return emptyTiles;
    }

    public boolean canMove(){
        for (int i= 0;i<FIELD_WIDTH;i++)
            for(int j = 0;j<FIELD_WIDTH;j++) {
                if (gameTiles[i][j].value==0)
                    return true;
                if (i!=0 && gameTiles[i][j].value==gameTiles[i-1][j].value)
                    return true;
                if (j!=0 && gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        return false;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() == 0) return;

        Tile tile = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
        tile.value = Math.random() < 0.9 ? 2 : 4;
    }

    private void rotate() {
        Tile[][] rotetedTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                rotetedTile[i][j] = gameTiles[FIELD_WIDTH-j-1][i];
        gameTiles = rotetedTile;
    }

    public void left() {
        boolean changed = false;
        for (int i = 0; i < FIELD_WIDTH; i++)
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                changed = true;
            }
        if (changed) {
            addTile();
        }
    }

    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void up() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    private boolean compressTiles(Tile[] tiles) {
        Tile tmp;
        boolean flag = true;
        boolean changed = false;
        while (flag) {
            flag = false;
            for (int i = 1; i < tiles.length; i++) {
                if (tiles[i - 1].value == 0 && tiles[i].value != 0) {
                    tmp = tiles[i - 1];
                    tiles[i - 1] = tiles[i];
                    tiles[i] = tmp;
                    flag = true;
                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean cahnged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value << 1;
                score += tiles[i].value;
                maxTile = Math.max(tiles[i].value, maxTile);
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                cahnged = true;
            }
        }
        return cahnged;
    }

    private void updateScoreAndMaxTile(int newValue) {
        score += newValue;
        if (newValue > maxTile)
            maxTile = newValue;
    }

}
