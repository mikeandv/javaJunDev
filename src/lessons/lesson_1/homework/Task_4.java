package lessons.lesson_1.homework;

public class Task_4 {
    public static void main(String[] args) {

        //

        int startPoint = 10;

        double m;
        double n;

        m = -7;
        n = 20;

        double mDistance = startPoint - m;
        double nDistance = startPoint - n;


        System.out.println("Число m = " + m);
        System.out.println("Число n = " + n);


        if ((Math.abs(mDistance) == (Math.abs(nDistance))))
        {
            System.out.println("Числа на одинаковом расстоянии от 10");

        } else
            {
                double res = (Math.abs(mDistance) > (Math.abs(nDistance)))? n : m;
                System.out.println("Ближайшее к 10 число " + res);
            }
    }
}
