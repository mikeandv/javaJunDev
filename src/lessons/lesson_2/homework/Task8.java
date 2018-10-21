package lessons.lesson_2.homework;

public class Task8 {
    public static void main(String[] args) {

        //координаты вершины X
        int verX_x = -5;
        int verX_y = 1;

        //координаты вершины Y
        int verY_x = 4;
        int verY_y = 2;

        //координаты вершины Z
        int verZ_x = -4;
        int verZ_y = -4;

        //Вспомогательная точка
        //int varC = 0;

        //Вычислим длинну отрезков XY, YZ и ZX
        double sectionXY = Math.abs( Math.sqrt( Math.pow((verY_x - verX_x), 2) + Math.pow((verY_y - verX_y), 2)));
        double sectionYZ = Math.abs( Math.sqrt( Math.pow((verZ_x - verY_x), 2) + Math.pow((verZ_y - verY_y), 2)));
        double sectionZX = Math.abs( Math.sqrt( Math.pow((verX_x - verZ_x), 2) + Math.pow((verX_y - verZ_y), 2)));

        if ((sectionXY == (Math.sqrt(Math.pow(sectionYZ, 2) + Math.pow(sectionZX, 2))))) {

            System.out.println("Треугольник прямоугольный");

        } else if ((sectionYZ == (Math.sqrt(Math.pow(sectionXY, 2) + Math.pow(sectionZX, 2))))) {

            System.out.println("Треугольник прямоугольный");

        } else if ((sectionZX == (Math.sqrt(Math.pow(sectionYZ, 2) + Math.pow(sectionXY, 2))))) {

            System.out.println("Треугольник прямоугольный");

        } else {

            System.out.println("Треугольник не прямоугольный");
        }


    }
}

