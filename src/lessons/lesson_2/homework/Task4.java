package lessons.lesson_2.homework;


import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int number = in.nextInt();

        //Проверка на четное
        if (number % 2 == 0) {
            System.out.println("Число " + number + " составное.");
            System.out.println("Проверка на четность");
        } else { // если нечетное то


            for (int i = 0; i < 100; i++) {

                int randomNum = ThreadLocalRandom.current().nextInt(2, number - 1);
                long a = randomNum;
                long x = number;


                //Проверка НОД
                if (gcd(randomNum, number) > 1) {
                    System.out.println("Число " + number + " составное.");
                    System.out.println("Проверка НОД.");
                    break;
                }

                //Тест Ферма
                if (pows(a, x - 1, x) != 1) {
                    System.out.println("Число " + number + " составное.");
                    System.out.println("Тест Ферма.");
                    break;
                }

//            //Получение символа Якоби
//            int r, t, c;
//            r = 1;
//            t = 0;
//
//            while (a % 2 == 0) {
//                t += 1;
//                a /= 2;
//
//            }
//            if (t % 2 != 0) {
//                if ((number % 8 == 3) || (number % 8 == 5)) {
//                    r = -r;
//                }
//            }
//            if (((a % 4) == (number % 4)) && (number % 4) == 3) {
//                r = -r;
//            }
//             //   c = randomNum;
//             //   randomNum = number % c;
//             //   number = c;
//            ////


//           BigDecimal pow, randNumB, numbB;
//           pow = BigDecimal.valueOf(randomNum);
//           randNumB = BigDecimal.valueOf(randomNum);
//
//            //Алгоритм Соловея — Штрассена
//            for (int j = 1; j < (number - 1) / 2; j++){
//                pow = pow.multiply(randNumB);//pow * randomNum;
//                    }
//
//            numbB = BigDecimal.valueOf(number);
//            BigDecimal b =  pow.remainder(numbB);
//
//            if (b.intValue() == r) {
//                //System.out.println("Число " + number + " составное.");
//                continue;
//            } else {
//                System.out.println("Число " + number + " составное.");
//            }
//
           if (i == 99) {

               System.out.println("Число " + number + " простое!");
               System.out.println("Тест Ферма.");
           }

            }

        }
    }

    public static int gcd (int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a%b);
    }

    public static long mul (long a, long b, long m){
        if (b == 1)
            return a;
        if (b % 2 == 0) {
            long t = mul(a, b/2, m);
            return (2 * t) % m;
        }
        return (mul(a, b-1, m) + a) % m;
    }
    public static long pows (long a, long b, long m){
        if (b == 0)
            return  1;
        if (b % 2 == 0) {
            long t = pows(a, b/2, m );
            return mul(t, t, m) % m;
        }
        return ( mul(pows(a, b-1, m), a, m)) % m;
    }
}
