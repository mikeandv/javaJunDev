package lessons.lesson_6.homework.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        Object obj = new Object();
        list1.push(obj);
        //list1.push(obj);

        System.out.println(list1.size());

        list1.pop();
        System.out.println(list1.size());


//        list1.add(obj,1);
//        list1.add(obj,9);

    }
}
