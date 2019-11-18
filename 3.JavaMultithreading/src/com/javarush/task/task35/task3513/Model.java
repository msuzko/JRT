package com.javarush.task.task35.task3513;

<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
<<<<<<< HEAD
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

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

<<<<<<< HEAD
    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0)
                    return true;
                if (i != 0 && gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
                if (j != 0 && gameTiles[i][j].value == gameTiles[i][j - 1].value)
=======
    public boolean canMove(){
        for (int i= 0;i<FIELD_WIDTH;i++)
            for(int j = 0;j<FIELD_WIDTH;j++) {
                if (gameTiles[i][j].value==0)
                    return true;
                if (i!=0 && gameTiles[i][j].value==gameTiles[i-1][j].value)
                    return true;
                if (j!=0 && gameTiles[i][j].value == gameTiles[i][j-1].value)
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
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
<<<<<<< HEAD
                rotetedTile[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
=======
                rotetedTile[i][j] = gameTiles[FIELD_WIDTH-j-1][i];
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        gameTiles = rotetedTile;
    }

    public void left() {
<<<<<<< HEAD
        if (isSaveNeeded)
            saveState(gameTiles);
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        boolean changed = false;
        for (int i = 0; i < FIELD_WIDTH; i++)
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                changed = true;
            }
        if (changed) {
            addTile();
<<<<<<< HEAD
            isSaveNeeded = true;
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        }
    }

    public void right() {
<<<<<<< HEAD
        saveState(gameTiles);
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
<<<<<<< HEAD
        saveState(gameTiles);
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void up() {
<<<<<<< HEAD
        saveState(gameTiles);
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
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

<<<<<<< HEAD
    private void saveState(Tile[][] tiles) {
        Tile[][] tileForSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tileForSave[i][j] = new Tile(tiles[i][j].value);
            }
        previousStates.push(tileForSave);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.empty() && !previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        if (n == 0)
            left();
        else if (n == 1)
            right();
        else if (n == 2)
            up();
        else if (n == 3)
            down();
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency;
        if (hasBoardChanged())
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    private boolean hasBoardChanged() {
        return getWeight(gameTiles) != getWeight(previousStates.peek());
    }

    private int getWeight(Tile[][] tiles) {
        int weight = 0;
        for (int i = 0; i < FIELD_WIDTH; i++)
            for (int j = 0; j < FIELD_WIDTH; j++)
                weight += tiles[i][j].value;
        return weight;
    }

=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}
