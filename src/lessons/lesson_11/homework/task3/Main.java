package lessons.lesson_11.homework.task3;

import lessons.lesson_11.homework.task1.StInput;


import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> str = new LinkedList<>();

        while (str.size() != 5) {
            str.add(StInput.read());
        }
        doubleValues(str);
    }

    public static void doubleValues(LinkedList<String> l) {

        ListIterator<String> listIterator = l.listIterator();

        while (listIterator.hasNext()) {

            if (!listIterator.hasPrevious())
                listIterator.next();

            listIterator.add(listIterator.previous());
            listIterator.next();

            if (listIterator.hasNext()) {
                listIterator.next();
                if(!listIterator.hasNext()) {
                    listIterator.add(listIterator.previous());
                    break;
                }
            }
        }

        for(String s : l) {
            System.out.println(s);
        }
    }
}

