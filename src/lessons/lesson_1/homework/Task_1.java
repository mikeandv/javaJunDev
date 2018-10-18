package lessons.lesson_1.homework;

public class Task_1 {

    public static void main(String[] args) {

        int width = 10;
        int height = 7;
        int length = 5;

        int resSq;

        //Вычисление площади параллелипипеда

        resSq = 2 * ((width * height) + (height * length) + (width * length));
        System.out.println(resSq);

        //Проверка, что больше ширина или высота

        boolean varCheck;
        varCheck = (width > height)? true:false;
        System.out.println("Ширина больше высоты? " + varCheck);

    }
}
