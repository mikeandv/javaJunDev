package lessons.lesson_6.homework.linkedlist;

public class LinkedList implements List, Stack, Queue {
    private Node first;


    @Override
    public void add(Object data, int index) {

        if(isEmpty()){
            this.first = new Node(data);
        } else if (preIndexNode(index) == null) {

            lastNode().setLink(new Node(data));
        } else {
            preIndexNode(index).setLink(new Node(data));
        }
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void get(int index) {

    }

    @Override
    public int size() {
        if(isEmpty())
            return 0;
        Node n = this.first;
        int count = 1;
        while (n.getLink() != null) {
            count++;
            n = n.getLink();
        }
        return count;
    }

    @Override
    public void shift(Object node) {
        if(isEmpty()){

        }


    }

    @Override
    public void unshift() {

    }

    @Override
    public void push(Object node) {
        if (isEmpty()) {
            this.first = new Node(node);
        } else {
            lastNode().setLink(new Node(node));
        }

    }

    @Override
    public void pop() {
        if(isEmpty()){

            System.out.println("Список пуст, нечего удалять");

        } else if(this.first.getLink() == null) {

            this.first = null;

        } else {

            Node n = this.first;
            while (n.getLink() != lastNode()){
                n = n.getLink();
            }
            n.setLink(null);
        }
    }

    /*
    * Вспомогательные методы
    *
    *
    */

    private Node preIndexNode (int index) {
        Node n = this.first;
        int indexInner = 0;

        while (indexInner != index){
            n = n.getLink();
        }
        return n;
    }

    private Node lastNode (){
        Node n = this.first;
        while (n.getLink() != null) {
            n = n.getLink();
        }
        return n;

    }

    private boolean isEmpty(){
        if(this.first == null)
            return true;
        return false;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

}
