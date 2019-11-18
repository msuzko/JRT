package com.javarush.task.task24.task2413;

<<<<<<< HEAD
/**
 * Базовый класс для всех объектов игры.
 */
public abstract class BaseObject {
    //координаты
    protected double x;
    protected double y;
    //радиус объекта
    protected double radius;

    protected BaseObject(double x, double y, double radius) {
=======
public abstract class BaseObject {
    protected double x, y, radius;

    public BaseObject(double x, double y, double radius) {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

<<<<<<< HEAD
    /**
     * Метод рисует свой объект на "канвасе".
     */
    abstract void draw(Canvas canvas);

    /**
     * Двигаем себя на один ход.
     */
    abstract void move();

    /**
     * Проверяем - не выходит ли (x,y) за границы.
     */
    void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    /**
     * Проверяем - пересекаются ли переданный(o) и наш(this) объекты.
     */
    boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
=======
    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;

        return Math.max(radius, o.radius) >= Math.sqrt(dx * dx + dy * dy);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
