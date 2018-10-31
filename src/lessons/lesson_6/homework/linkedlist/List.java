package lessons.lesson_6.homework.linkedlist;

public interface List {

    void add(Object data, int index);
    void remove(int index);
    Node get(int index);
    int size();

}
