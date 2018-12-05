package lessons.chat;

import java.util.Scanner;

public class ConsoleHelper {
        private static Scanner s;
//        private static String string;

        public static String readString(){

            String string = "";
            boolean isTry = true;

            while (isTry) {

                try {
                    s = new Scanner(System.in);
                    string = s.nextLine();
                    if (string.equals(""))
                        throw new IllegalArgumentException("Ошибка! Введена пустая строка");
                    isTry = false;
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            return string;
        }

        public static void writeString(String st) {
            System.out.println(st);
        }
}
