package lessons.lesson_4.homework.TaskOOP2;

public class Storage {
    private Node first;
    private Node last;

    public void add (int num) {
        Node n = new Node();
        n.value = num;

        if (first == null) {
            first = n;
            last = n;
        }
        else {
            last.nextN = n;
            last = n;
        }
    }
    public void print () {
        Node n = first;
        while (n != null){
            System.out.println(n.value + " ");
            n = n.nextN;
        }
        System.out.println(" ");
    }
    public void remove (int num) {
        Node n = first;
        while (n.nextN != null) {
            if (n.nextN.value == num){
                n.nextN = n.nextN.nextN;
                return;
            }
            n = n.nextN;
        }

    }

}
