package lessons.lesson_11.homework.task5;

import lessons.lesson_11.homework.task1.StInput;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TaskFiveM {

    public static void main(String[] args) {

        List<String> str = new LinkedList<>();

        while (str.size() != 10) {
            str.add(StInput.read());
        }

        int len = 0;
        int i = 0;

        for (String s : str) {

            if (s.length() >= len) {
                len = s.length();
            } else {
                System.out.println("Список не упорядоченный!");
                System.out.println(i);
                break;
            }
            if (i == str.size()-1)
                System.out.println("Список упорядоченный по возрастанию длинны строки");
            i++;
        }
    } //6 2 4
}
