package lessons.lesson_3.homework;

import java.util.Arrays;

public class TaskArray2 {
    public static void main(String[] args) {

        int[] arrOdd = new int[100/2];


        for (int i = 0; i < arrOdd.length; i++){
            arrOdd[i] = 1 + 2 * i;
        }

        System.out.println(Arrays.toString(arrOdd));

        for (int i = 0; i < arrOdd.length / 2; i++){

            int tmp = arrOdd[i];
            arrOdd[i] = arrOdd[arrOdd.length - i - 1];
            arrOdd[arrOdd.length -1- i] = tmp;
        }

        System.out.println(Arrays.toString(arrOdd));
    }
}
