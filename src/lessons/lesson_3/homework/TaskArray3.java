package lessons.lesson_3.homework;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class TaskArray3 {
    public static void main(String[] args) {

        //Счетчик
        int countEven = 0;

        int[] arrRand = new int[15];
        for (int i = 0; i < arrRand.length; i++) {

            //Случайное число
            int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
            arrRand[i] = randomNum;

            //Если четное то инкрементируется счетчик
            if (arrRand[i] % 2 == 0)
                countEven++;
        }

        //Вывод массива
        System.out.println(Arrays.toString(arrRand));

        //Вывод результата инкремента
        System.out.println("Количество четных элементов в массиве = " + countEven);
    }
}
