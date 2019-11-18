package com.javarush.task.task24.task2413;

<<<<<<< HEAD
/**
 * Класс для объекта "кирпич".
 */
public class Brick extends BaseObject {
    //картинка для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

=======
public class Brick  extends BaseObject{
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    public Brick(double x, double y) {
        super(x, y, 3);
    }

<<<<<<< HEAD
    /**
     * Рисуем себя на холсте
     */
    @Override
    void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    /**
     * Ничего не делаем - кирпич неподвижен
     */
    @Override
    void move() {
        //do nothing
=======
    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
