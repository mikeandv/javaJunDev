package lessons.lesson_2.homework;

public class Task8 {
    public static void main(String[] args) {

        //координаты вершины X
        int verX_x = -3;
        int verX_y = -3;

        //координаты вершины Y
        int verY_x = -3;
        int verY_y = -8;

        //координаты вершины Z
        int verZ_x = -10;
        int verZ_y = -3;


        int sectionXY = (int) Math.pow((verY_x - verX_x), 2) + (int) Math.pow((verY_y - verX_y), 2);
        int sectionYZ = (int) Math.pow((verZ_x - verY_x), 2) + (int) Math.pow((verZ_y - verY_y), 2);
        int sectionZX = (int) Math.pow((verX_x - verZ_x), 2) + (int) Math.pow((verX_y - verZ_y), 2);

        if (sectionXY == (sectionYZ + sectionZX)) {

            System.out.println("Треугольник прямоугольный");

        } else if (sectionYZ == (sectionXY + sectionZX)) {

            System.out.println("Треугольник прямоугольный");

        } else if (sectionZX == (sectionYZ + sectionXY)) {

            System.out.println("Треугольник прямоугольный");

        } else {

            System.out.println("Треугольник не прямоугольный");
        }


    }
}

