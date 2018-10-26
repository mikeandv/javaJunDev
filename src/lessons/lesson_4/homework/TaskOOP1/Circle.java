package lessons.lesson_4.homework.TaskOOP1;

import java.util.Arrays;

public class Circle {

    private PointCoordinate[] circleArr;
    private int arrCircleSize = 2;


    public Circle() {
        this.circleArr = new PointCoordinate[arrCircleSize];

        PointCoordinate coordinate = new PointCoordinate(2, 2);
        circleArr[0] = coordinate;

        coordinate = new PointCoordinate(10, 2);
        circleArr[1] = coordinate;

    }
    public void setTrianglArr (PointCoordinate point, int elem) {
        circleArr[elem] = point;
    }

    public double gfd (int num1, int num2) {
        PointCoordinate point1 = new PointCoordinate();
        PointCoordinate point2 = new PointCoordinate();

        point1 = getTriangleArrByIndex(num1);
        point2 = getTriangleArrByIndex(num2);
        return Math.sqrt( Math.pow( point2.getX()-point1.getX(), 2) + Math.pow( point2.getY() - point1.getY(), 2));
    }

    public PointCoordinate getTriangleArrByIndex(int indx) {
        return circleArr[indx];
    }

    public double square () {
        return Math.PI * Math.pow(gfd(0,1), 2);
    }

    public double perimeter () {
        return 2 * Math.PI * gfd(0,1);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "rectArr=" + Arrays.toString(circleArr) +
                '}';
    }

}
