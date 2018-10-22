package lessons.lesson_2.homework;


import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int number = in.nextInt();

        for (int i = 0; i < 10; i++ ) {

            int randomNum = ThreadLocalRandom.current().nextInt(2, number - 1);
            double a = randomNum;

            //Проверка на четное
            if (number % 2 == 0) {
                System.out.println("Число " + number + " составное.");
                break;
            }
            //


            //Проверка НОД
            if (gcd(randomNum, number) > 1) {
                System.out.println("Число " + number + " составное.");
                break;
            }

            //Получение символа Якоби
            int r, t, c;
            r = 1;
            t = 0;

            while (a % 2 == 0) {
                t += 1;
                a /= 2;

            }
            if (t % 2 != 0) {
                if ((number % 8 == 3) || (number % 8 == 5)) {
                    r = -r;
                }
            }
            if (((a % 4) == (number % 4)) && (number % 4) == 3) {
                r = -r;
            }
             //   c = randomNum;
             //   randomNum = number % c;
             //   number = c;
            ////


           BigDecimal pow, randNumB, numbB;
           pow = BigDecimal.valueOf(randomNum);
           randNumB = BigDecimal.valueOf(randomNum);

            //Алгоритм Соловея — Штрассена
            for (int j = 1; j < (number - 1) / 2; j++){
                pow = pow.multiply(randNumB);//pow * randomNum;
                    }

            numbB = BigDecimal.valueOf(number);
            BigDecimal b =  pow.remainder(numbB);

            if (b.intValue() == r) {
                //System.out.println("Число " + number + " составное.");
                continue;
            } else {
                System.out.println("Число " + number + " составное.");
            }

           if (i == 9) {

               System.out.println("Число " + number + " простое, с вероятностью " + (1 - (Math.pow(2, -9 ))));
           }

        }

    }

    public static int gcd (int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a%b);
    }
}
