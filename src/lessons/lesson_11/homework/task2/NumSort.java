package lessons.lesson_11.homework.task2;

import java.util.ArrayList;

public class NumSort {
    private ArrayList<Integer> arr;
    private ArrayList<Integer> arrDiv3;
    private ArrayList<Integer> arrDiv2;
    private ArrayList<Integer> arrOther;

    public NumSort() {
        this.arr = loadToArr();
        this.arrDiv3 = div3Sort(this.arr);
        this.arrDiv2 = div2Sort(this.arr);
        this.arrOther = otherSort(this.arr);
    }

    private ArrayList<Integer> loadToArr(){

        ArrayList<Integer> temp = new ArrayList<>();

        while(temp.size() < 20) {
            temp.add(NumIn.read());
        }
        return temp;
    }

    private ArrayList<Integer> div3Sort(ArrayList<Integer> arr) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (Integer i : arr) {
            if (i%3 == 0){
                temp.add(i);
            }
        }
        return temp;
    }

    private ArrayList<Integer> div2Sort(ArrayList<Integer> arr) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (Integer i : arr) {
            if (i%2 == 0){
                temp.add(i);
            }
        }
        return temp;
    }
    private ArrayList<Integer> otherSort(ArrayList<Integer> arr) {

        ArrayList<Integer> temp = new ArrayList<>();

        for (Integer i : arr) {
            if ((i%3 != 0) && (i%2 != 0)) {
                temp.add(i);
            }
        }
        return temp;
    }

    public void printLists() {
        System.out.println(arr.toString());
        System.out.println(arrDiv3.toString());
        System.out.println(arrDiv2.toString());
        System.out.println(arrOther.toString());
    }

    public void printSpecList(String listName) {

        switch (listName) {
            case "arr":
                System.out.println(arr.toString());
                break;
            case "arrDiv3":
                System.out.println(arrDiv3.toString());
                break;
            case "arrDiv2":
                System.out.println(arrDiv2.toString());
                break;
            case "arrOther":
                System.out.println(arrOther.toString());
                break;
            default:
                System.out.println(listName + " - Такого списка нет!");
        }
    }
}
