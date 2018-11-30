package lessons.lesson_11.homework.task1;

import java.util.Scanner;

public class StInput {
    private static Scanner s;

    public static String read(){

        String str = "";
        boolean isTry = true;

        while (isTry) {

            try {
                s = new Scanner(System.in);
                str = s.nextLine();
                if (str.equals(""))
                    throw new IllegalArgumentException("Ошибка! Введена пустая строка");
                isTry = false;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return str;
    }
}
