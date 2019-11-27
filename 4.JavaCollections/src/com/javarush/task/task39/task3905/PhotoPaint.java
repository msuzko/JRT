package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y < 0 || x < 0 || y >= image.length || x >= image[y].length || desiredColor == image[y][x])
            return false;
        Color oldColor = image[y][x];
        image[y][x] = desiredColor;
        if (y - 1 >= 0 && image[y - 1][x] == oldColor)
            paintFill(image, y - 1, x, desiredColor);
        if (y + 1 < image.length && image[y + 1][x] == oldColor)
            paintFill(image, y + 1, x, desiredColor);
        if (x - 1 >= 0 && image[y][x - 1] == oldColor)
            paintFill(image, y, x - 1, desiredColor);
        if (x + 1 < image[y].length && image[y][x + 1] == oldColor)
            paintFill(image, y, x + 1, desiredColor);
        return true;
    }

}
