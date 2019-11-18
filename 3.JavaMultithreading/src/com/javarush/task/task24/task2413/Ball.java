package com.javarush.task.task24.task2413;

<<<<<<< HEAD
/**
 * Класс для шарика в игре
 */
public class Ball extends BaseObject {
    // скорость
    private double speed;
    // направление  (в градусах от 0 до 360)
    private double direction;

    // текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    // заморожен ли объект или может двигаться
=======
public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx, dy;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
<<<<<<< HEAD

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
=======
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

<<<<<<< HEAD
=======
    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    public double getDx() {
        return dx;
    }

<<<<<<< HEAD
=======
    public void setDx(double dx) {
        this.dx = dx;
    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    public double getDy() {
        return dy;
    }

<<<<<<< HEAD
    /**
     * Устанавливаем новое направление движения.
     * Тут же вычисляем и новый вектор.
     * Такой подход удобно использовать при отскоках от стен.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    /**
     * Рисуем себя на "канвасе".
     */
    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Двигаем себя на один шаг.
     */
    public void move() {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arkanoid.game.getWidth(), 1, Arkanoid.game.getHeight() + 5);
    }

    /**
     * Проверяем не улетел ли шарик за стенку.
     * Если да - отражаем его.
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Запускам шарик.
     * isFrozen = false.
     * Пересчитываем вектор движения (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        this.isFrozen = false;
=======
    public void setDy(double dy) {
        this.dy = dy;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if (!isFrozen) {
            x += dx;
            y += dy;
        }
    }

    public void start() {
        isFrozen = false;
    }

    public void checkRebound(int minx, int maxx, int miny, int maxy){

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
