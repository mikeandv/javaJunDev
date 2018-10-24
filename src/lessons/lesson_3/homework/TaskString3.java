package lessons.lesson_3.homework;

import java.util.Arrays;

public class TaskString3 {
    public static void main(String[] args) {
        //дом 48, корпус 9, парадная 7, этаж 4
        StringBuffer stringSt = new StringBuffer("дом 48, корпус 9_1, парадная 7, этаж 4 4");
        String strToArr;
        int arrInx = 0;
        int[] arr = new int[stringSt.length()];

        for (int i = 0; i < stringSt.length(); i++){


            //Проверка, что символ является числом
            if (Character.isDigit(stringSt.charAt(i))) {
                strToArr = String.valueOf(stringSt.charAt(i));

                //Проверка, что следующий символ тоже число
                int k = i + 1;

                while ( (i != stringSt.length() - 1) && ((Character.isDigit(stringSt.charAt(k))) && (k < stringSt.length() )) ) {

                    //Если число, то плюсуем строки чля получения значения
                    strToArr += String.valueOf(stringSt.charAt(k));
                    //Инктеменируем k для проверки следующего символа
                    k++;
                    //Инкрементируем i чтобы чикл проверял следующие значения
                    i++;
                }
                //Помещаем значение переменной в элемент массива
                arr[arrInx] = Integer.parseInt(strToArr);
                //Инкрементируем счетчик элементов массива для его пересоздания
                arrInx++;

            }
        }
        //Создаем копию массива, но уже заданной длинны (по количеству элементов)
        int[] copyByRange = Arrays.copyOfRange(arr, 0,arrInx);

        System.out.println(Arrays.toString(copyByRange));
    }
}
