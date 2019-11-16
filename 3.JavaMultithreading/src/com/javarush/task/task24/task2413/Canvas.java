package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        initMatrix();
        //matrix = new char[height + 2][width + 2];
    }

    private void initMatrix() {
        matrix = new char[height + 2][width + 2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    void setPoint(double x, double y, char c) {
        if (x < 0 || y < 0 || y > matrix.length || x > matrix[0].length) return;
        int nx = (int) Math.round(x);
        int ny = (int) Math.round(y);
        matrix[ny][nx] = c;
    }

    void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0)
                    setPoint(x + j, y + i, c);
            }
    }

    public void clear(){
        initMatrix();
    }

    public void print(){
        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
