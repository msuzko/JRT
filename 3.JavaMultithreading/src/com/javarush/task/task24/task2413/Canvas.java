package com.javarush.task.task24.task2413;

<<<<<<< HEAD
/**
 * Класс-холст для отрисовки.
 */
public class Canvas {
    //ширина и высота
    private int width;
    private int height;
    //матрица, где рисуем. символ - это цвет.
=======
public class Canvas {
    private int width, height;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
<<<<<<< HEAD
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Очищаем холст
     */
    void clear() {
        this.matrix = new char[height + 2][width + 2];
    }

    /**
     * Печатаем переданную фигуру в указанных координатах цветом c.
     * Если переданный массив содержит единицы, то на холсте им будут соответствовать символы - с.
     */
    void drawMatrix(double x, double y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1)
                    setPoint(x + j, y + i, c);
            }
        }
    }

    /**
     * Ставим одну точку на холсте с координатами (x,y) и цветом - c.
     */
    void setPoint(double x, double y, char c) {
        int x0 = (int) Math.round(x);
        int y0 = (int) Math.round(y);
        if (y0 < 0 || y0 >= matrix.length) return;
        if (x0 < 0 || x0 >= matrix[y0].length) return;

        matrix[y0][x0] = c;
    }

    /**
     * Печатаем содержимое холста на экран.
     */
    void print() {
        System.out.println();

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
=======
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
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
