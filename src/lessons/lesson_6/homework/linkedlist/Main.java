package lessons.lesson_6.homework.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        String obj = "st1"; //= new Object();
        String obj1 = "st2"; //= new Object();


        list1.shift(obj);
        list1.shift(obj1);
        list1.printList();
        System.out.println();
//
//
//        list1.shift(obj);
//        list1.printList();
//        System.out.println();
//        list1.shift(obj);
//        list1.printList();
//        System.out.println();
//        list1.push(obj);
//        list1.printList();
//        System.out.println();
//        list1.add(obj1,7);
//        list1.printList();
//        System.out.println();
//        System.out.println(list1.get(5));
//        list1.add(obj1,5);
//        System.out.println(list1.get(5));

        list1.remove(1);
        list1.printList();

//        System.out.println(list1.size());
//
//        list1.pop();
//        System.out.println(list1.size());
//        list1.shift(obj);
//
//        //list1.unshift();
//        System.out.println(list1.size());
//        list1.printList();



//        list1.add(obj,1);
//        list1.add(obj,9);

    }
}
