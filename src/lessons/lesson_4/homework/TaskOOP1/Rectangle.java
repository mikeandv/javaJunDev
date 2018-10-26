package lessons.lesson_4.homework.TaskOOP1;

import java.util.Arrays;
import java.util.Scanner;

public class Rectangle {

    private PointCoordinate[] rectArr;
    private int arrRectSize = 4;

    public Rectangle() {
        this.rectArr = new PointCoordinate[arrRectSize];

        PointCoordinate coordinate = new PointCoordinate(2,2);
        rectArr[0] = coordinate;

        coordinate = new PointCoordinate(10,2);
        rectArr[1] = coordinate;

        coordinate = new PointCoordinate(2,8);
        rectArr[2] = coordinate;

        coordinate = new PointCoordinate(10,8);
        rectArr[3] = coordinate;
//        Scanner in = new Scanner(System.in);
//
//        for (int i = 0; i < rectArr.length; i++) {
//
//            System.out.print("Введите X для точки " + (i + 1) + " ");
//            double x = in.nextDouble();
//            System.out.print("Введите Y для точки " + (i + 1) + " ");
//            double y = in.nextDouble();
//
//            coordinate = new PointCoordinate(x, y);
//            rectArr[i] = coordinate;
//        }
    }

    public void setRectArr (PointCoordinate point, int elem) {
            rectArr[elem] = point;
    }

    public double gfd (int num1, int num2) {
        PointCoordinate point1 = new PointCoordinate();
        PointCoordinate point2 = new PointCoordinate();

        point1 = getRectArrByIndex(num1);
        point2 = getRectArrByIndex(num2);
        return Math.sqrt( Math.pow( point2.getX()-point1.getX(), 2) + Math.pow( point2.getY() - point1.getY(), 2));
    }

    public PointCoordinate getRectArrByIndex(int indx) {
        return rectArr[indx];
    }

    public double square () {
        return gfd(0,1) * gfd(0,2);
    }
    public double perimeter () {
        return (gfd(0,1) + gfd(0,2)) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "rectArr=" + Arrays.toString(rectArr) +
                '}';
    }
}
