package lessons.lesson_6.homework.linkedlist;

public class LinkedList implements List, Stack, Queue {
    private Node first;


    @Override
    public void add(Object data, int index) {

        if(isEmpty()){
            shift(new Node(data));
        } else if (index > size() + 1) {
            push(data);
            System.out.println("Индекс превышает размер листа, элемент добавлен в конец");
        } else {
            get(index).setData(data);
        }
    }

    @Override
    public void remove(int index) {
        if(isEmpty()) {
            System.out.println("Список пуст, нечего удалять");
        } else if(index > size()){
            System.out.println("Нет элемента по заданному индексу");
        } else {
            if(get(index) == this.first) {
                unshift();
            } else if(get(index) == lastNode()) {
                pop();
            } else {
                get(index - 1).setLink(get(index).getLink());
            }
        }

    }

    @Override
    public Node get(int index) {
        if (isEmpty())
            return null;

        Node n = this.first;
        for (int i = 1; i < index; i++){
            n = n.getLink();
        }
        return n;
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
    public void shift(Object data) {
        if(isEmpty()) {
            setFirst(new Node(data));
        } else {
            Node n = new Node(data);
            n.setLink(this.first);
            setFirst(n);
        }
    }

    @Override
    public void unshift() {
        if(isEmpty()){
            System.out.println("Список пуст, нечего удалять");
        } else if(this.first.getLink() == null){
            setFirst(null);
        } else {
            setFirst(this.first.getLink());
        }
    }

    @Override
    public void push(Object data) {
        if (isEmpty()) {
            setFirst(new Node(data));
        } else {
            lastNode().setLink(new Node(data));
        }
    }

    @Override
    public void pop() {
        if(isEmpty()){

            System.out.println("Список пуст, нечего удалять");

        } else if(this.first.getLink() == null) {

            setFirst(null);

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
    */

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

    private void setFirst(Node node) {
        this.first = node;
    }

    public void printList(){
        Node n = this.first;

        for (int i = 1; i != size() + 1; i++) {
            System.out.println("Node = " + n + ", " + "Index = " + i);
            n = n.getLink();
        }
    }
}

