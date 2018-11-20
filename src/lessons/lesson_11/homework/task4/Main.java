package lessons.lesson_11.homework.task4;

import lessons.lesson_11.homework.task1.StInput;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<String> str = new LinkedList<>();

        while (str.size() != 5) {
            str.add(StInput.read());
        }

        str.remove(2);

        ListIterator<String> iterator = str.listIterator(str.size());

        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }
    }
}
