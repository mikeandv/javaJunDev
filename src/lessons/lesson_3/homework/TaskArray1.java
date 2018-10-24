package lessons.lesson_3.homework;

import java.util.Arrays;

public class TaskArray1 {
    public static void main(String[] args) {

        int[] arrInt = new int[10];

        for (int i = 0; i < arrInt.length; i++) {

            arrInt[i] = (i + 1) * 2;
            System.out.print(arrInt[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arrInt.length; i++) {
            System.out.println(arrInt[i]);
        }



    }
}
