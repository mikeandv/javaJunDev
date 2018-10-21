package lessons.lesson_2.homework;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Укажите количество тарелок");
        int platesCNT = in.nextInt();

        System.out.println("Задайте кличество моющего средства");
        double cleanserCNT = in.nextDouble();

        for (int i = platesCNT; i > 0; i--) {

            System.out.println("Тарелка помыта.");


            if (cleanserCNT >= 0.5) {
                cleanserCNT -= 0.5;

                System.out.print("Осталось моющего средства ");
                System.out.printf("%.1f", cleanserCNT);
                System.out.println();

            } else {
                System.out.println("Моющее вредство закончилось!");
                System.out.println("Осталось " + i + " немытых тарелок");
                break;

            }
            if (i == 1) {
                System.out.print("Все тарелки помыты!\nМоющего средства осталось ");
                System.out.printf("%.1f", cleanserCNT);
            }


        }



    }
}
