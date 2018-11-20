package lessons.lesson_11.homework.task2;

import java.util.InputMismatchException;
import java.util.Scanner;
//import java.sql.Connection

public class NumIn {
    private static Scanner s;

    private NumIn() {
    }

    public static int read(){

        int num = 0;
        boolean isTry = true;

        while (isTry) {

            try {
                s = new Scanner(System.in);
                num = s.nextInt();
//                if (s == "")
//                    throw new IllegalArgumentException("Ошибка! Введена пустая строка");
                isTry = false;
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}
