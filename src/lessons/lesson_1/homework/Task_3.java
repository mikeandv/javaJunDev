package lessons.lesson_1.homework;

public class Task_3 {

    public static void main(String[] args) {

        //Площадь овала 15 дм2
        //Из него вырезали овал прощадью 600 см2
        //Найти площадь овального кольца
        //

        int ovalS = 15;
        int ovalSCut = 600;

        int ovalSInSm = ovalS * 100;

        int res = ovalSInSm - ovalSCut;

        System.out.println("Площадь овального кольца равна " + res + " см2");

    }
}
