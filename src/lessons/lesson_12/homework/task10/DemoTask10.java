package lessons.lesson_12.homework.task10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class DemoTask10 {
    public static void main(String[] args) {

        Set<Integer>  integers = new LinkedHashSet<>();

        while(integers.size() != 20) {
            integers.add(ThreadLocalRandom.current().nextInt(1, 25));
        }

        for(Integer i : integers) {
            System.out.println(i);
        }

        System.out.println("++++++++");

        Iterator<Integer> integerIterator = integers.iterator();

        while(integerIterator.hasNext()) {
            if(integerIterator.next() > 10)
                integerIterator.remove();
        }

        for(Integer i : integers) {
            System.out.println(i);
        }
    }
}
