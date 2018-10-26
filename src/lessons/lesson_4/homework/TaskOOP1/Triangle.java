package lessons.lesson_4.homework.TaskOOP1;

import java.util.Arrays;

public class Triangle {

    private PointCoordinate[] trianglArr;
    private int arrTrianglSize = 3;

    public Triangle() {
        this.trianglArr = new PointCoordinate[arrTrianglSize];

        PointCoordinate coordinate = new PointCoordinate(2, 2);
        trianglArr[0] = coordinate;

        coordinate = new PointCoordinate(10, 2);
        trianglArr[1] = coordinate;

        coordinate = new PointCoordinate(2, 8);
        trianglArr[2] = coordinate;
    }
        public void setTrianglArr (PointCoordinate point, int elem) {
            trianglArr[elem] = point;
        }

        public double gfd (int num1, int num2) {
            PointCoordinate point1 = new PointCoordinate();
            PointCoordinate point2 = new PointCoordinate();

            point1 = getTriangleArrByIndex(num1);
            point2 = getTriangleArrByIndex(num2);
            return Math.sqrt( Math.pow( point2.getX()-point1.getX(), 2) + Math.pow( point2.getY() - point1.getY(), 2));
        }

        public PointCoordinate getTriangleArrByIndex(int indx) {
            return trianglArr[indx];
        }

        public double square () {
            return Math.sqrt((perimeter() / 2) * (perimeter()/2 - gfd(0,1)) * (perimeter()/2 - gfd(1,2)) * (perimeter()/2 - gfd(2,0)));
        }

        public double perimeter () {
            return (gfd(0,1) + gfd(1,2) + gfd(2,0));
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "rectArr=" + Arrays.toString(trianglArr) +
                    '}';
        }
    }

