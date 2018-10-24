package lessons.lesson_3.homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TaskArray4 {
    public static void main(String[] args) {

        System.out.println("Введите четное положительное число:");
        Scanner in = new Scanner(System.in);

        //Вервичны ввод числа пользователем
        //
        int arrSize = in.nextInt();

        //Проверка, что введено корректное числоб если нет то повторный ввод
        //
        while (arrSize <= 0 || (arrSize % 2 != 0)){
            System.out.println("Вы ввели некорректное число попробуйте еще раз");
            arrSize = in.nextInt();
        }

        //Создание массива заданного пользователем размера
        //
        int[] arrUserSize = new int[arrSize];

        //Заполнение элементов массива случайными числами в диапазоне [-5; 5]
        //
        for (int i = 0; i < arrUserSize.length; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(-5, 5);
            arrUserSize[i] = randomNum;
        }

        System.out.println(Arrays.toString(arrUserSize));

        //Проверка суммы по модулю левой и правоч части
        //
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arrUserSize.length; i++) {
            if (i < arrUserSize.length / 2) {
                leftSum += Math.abs(arrUserSize[i]);
            } else {
                rightSum += Math.abs(arrUserSize[i]);
            }
        }

        //Вывод результатов сравнение суммы элементов по модулю левой и правочй части
        //
        if (leftSum > rightSum) {
            System.out.println("Сумма модулей значений левой половины массива больше");
        } else if (rightSum > leftSum) {
            System.out.println("Сумма модулей значений правой половины массива больше");
        } else {
            System.out.println("Сумма модулей значений правой и левой половины равны");
        }

    }
}
