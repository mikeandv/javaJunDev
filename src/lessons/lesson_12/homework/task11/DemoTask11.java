package lessons.lesson_12.homework.task11;

import java.util.*;

public class DemoTask11 {
    public static void main(String[] args) {
        ArrayList<String> arrSt = new ArrayList<>();
        LinkedList<String> linkSt = new LinkedList<>();

//        TaskLists t = new TaskLists(arrSt);
//        TaskLists l = new TaskLists(linkSt);

//        System.out.println(t.getTimeOfInsert());
//        System.out.println(t.getTimeOfInsert());
//        System.out.println("+++++++++++++++++");
//        System.out.println(l.getTimeOfInsert());
//        System.out.println(l.getTimeOfInsert());
//        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println(getTimeOfInsert(arrSt));
        System.out.println(getTimeOfInsert(linkSt));
        get10000(arrSt);
        get10000(linkSt);

        set10000(arrSt);
        set10000(linkSt);

        remove10000(arrSt);
        remove10000(linkSt);

        System.out.println(arrSt.size());
        System.out.println(linkSt.size());

    }

    public static double getTimeOfInsert(List list){
        long st, en;
        st = System.nanoTime();

        for(int i = 0; i < 10000; i++) {
            list.add("String {" + i + "}");
        }
        en = System.nanoTime();

        return (double) (en - st) / (double) 1_000_000;
    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add("String {" + i + "}");
        }
    }
    public static void get10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
    }
    public static void set10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.set(i,list.get(i) + "set");
        }

    }
    public static void remove10000(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();

        }
    }
}
