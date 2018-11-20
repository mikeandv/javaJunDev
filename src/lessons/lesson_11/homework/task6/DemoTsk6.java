package lessons.lesson_11.homework.task6;

import lessons.lesson_11.homework.task1.StInput;
import lessons.lesson_11.homework.task2.NumIn;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DemoTsk6 {
    public static void main(String[] args) {

        System.out.println("Введите число N:");
        int n = NumIn.read();
        System.out.println("Введите число M:");
        int m = NumIn.read();

        List<String> str = new LinkedList<>();

        System.out.println("Введите " + n + " строк");

        while (str.size() != n) {
            str.add(StInput.read());
        }

        List<String> tmp = new LinkedList<>();

        ListIterator<String> iterator = str.listIterator();

        int i = 0;
        while(i != m) {
            tmp.add(iterator.next());
            iterator.remove();
            i++;
        }

        str.addAll(tmp);

        for (String s : tmp) {
            System.out.println(s + "'");
        }
        for(String s : str) {
            System.out.println(s+ "-");
        }


    }
}


