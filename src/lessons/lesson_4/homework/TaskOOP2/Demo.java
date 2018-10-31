package lessons.lesson_4.homework.TaskOOP2;

public class Demo {
    public static void main(String[] args) {
        Storage list = new Storage();
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(99);

        list.print();

        list.remove(1);
        list.print();
        list.remove(99);

        list.add(55);
        list.print();



    }
}
