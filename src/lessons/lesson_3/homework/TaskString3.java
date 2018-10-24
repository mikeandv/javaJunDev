package lessons.lesson_3.homework;

import java.util.Arrays;

public class TaskString3 {
    public static void main(String[] args) {
        //дом 48, корпус 9, парадная 7, этаж 4
        StringBuffer stringSt = new StringBuffer("дом 48, корпус 9_1, парадная 7, этаж 4 4h");
        String strToArr;
        int arrInx = 0;
        int[] arr = new int[stringSt.length()];

        for (int i = 0; i < stringSt.length() - 1; i++){

            if (Character.isDigit(stringSt.charAt(i))) {
                strToArr = String.valueOf(stringSt.charAt(i));

                int k = i + 1;
                while ( (Character.isDigit(stringSt.charAt(k)) && (k < stringSt.length() - 1) ) ) {
                    strToArr += String.valueOf(stringSt.charAt(k));
                    k++;
                    i++;
                }
                arr[arrInx] = Integer.parseInt(strToArr);
                arrInx++;

            }
        }
        int[] copyByRange = Arrays.copyOfRange(arr, 0,arrInx);

        System.out.println(Arrays.toString(copyByRange));
    }
}
