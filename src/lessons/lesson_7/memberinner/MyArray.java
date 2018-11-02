package lessons.lesson_7.memberinner;

import java.util.Iterator;

public class MyArray {
    private Object[] array;

    public MyArray() {

        array = new Object[10];

        for(int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i);
        }

    }

    public Iterator evenIterator() {
        return new EventIterator();
    }

    private class EventIterator implements Iterator {
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < array.length;
        }

        @Override
        public Object next() {
            Object next = array[nextIndex];
            nextIndex += 2;
            return next;
        }
    }
}
