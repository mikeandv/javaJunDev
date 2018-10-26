package lessons.lesson_4.homework.TaskOOP1;

import java.util.Arrays;

public class PointCoordinate {
    private double x;
    private double y;

    public PointCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public PointCoordinate() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PointCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
