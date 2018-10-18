package lessons.lesson_1.homework;

public class Task_6 {

    public static void main(String[] args) {

        double a = 1.5;
        double b = -9;
        double c = 3.68;


        double discr = (b * b) - (4 * (a * c) );

        if (discr > 0) {

            double x1;
            double x2;

            x1 = (-b + Math.sqrt(discr))/ (2 * a);
            x2 = (-b - Math.sqrt(discr))/ (2 * a);

            System.out.println("Решение квадратного уравнения "+ a + "x² + " + b + "x + " + c + " = 0 имеет два корня");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);

        } else if (discr == 0) {

            double x;

            x = - (b / (2 * a));
            System.out.println("Решение квадратного уравнения "+ a + "x² + " + b + "x + " + c + " = 0 имеет один корень");
            System.out.println("x = " + x);

        } else {

            System.out.println("Квадратное уравнение "+ a + "x² + " + b + "x + " + c + " = 0 не имеет корней");

        }


    }
}
