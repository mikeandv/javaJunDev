package lessons.lesson_1.homework;

public class Task_2 {
    public static void main(String[] args) {

        //Условия задачи
        //10 соток = 1000 м2
        //Грядки 15Х25 м
        //Сколько останется м2 свободно на участке?

        int areaS = 10;
        int areaSqInM2 = (10 * 10) * areaS;
        int gardS = 15 * 25;

        int res = areaSqInM2 - gardS;

        System.out.println("Незянятым осталость " + res + " m2");

    }
}
