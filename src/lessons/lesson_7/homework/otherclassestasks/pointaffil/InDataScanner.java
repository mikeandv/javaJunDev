package lessons.lesson_7.homework.otherclassestasks.pointaffil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InDataScanner {
    private static Scanner s;

    private InDataScanner(){}

     public static int readFromInput(){

        int num = 0;
        boolean isTry = true;

        while (isTry) {

            try {
                System.out.print("Введите целое число не равное нулю: ");
                s = new Scanner(System.in);
                num = s.nextInt();
                if(num == 0)
                    throw new IllegalArgumentException("Ошибка! Введен ноль");
                isTry = false;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введено некорректное значение.\n");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}
