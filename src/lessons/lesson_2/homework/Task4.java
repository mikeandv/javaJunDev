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

           BigDecimal pow, randNumB, numbB;
           pow = BigDecimal.valueOf(randomNum);
           randNumB = BigDecimal.valueOf(randomNum);


            for (int j = 1; j < number - 1; j++){
                pow = pow.multiply(randNumB);//pow * randomNum;
                    }


            numbB = BigDecimal.valueOf(number);
            BigDecimal b =  pow.remainder(numbB);


            if (b.intValue() != 1) {
                System.out.println("Число " + number + " составное.");
                break;
           }
           if (i ==9){
               System.out.println("Число " + number + " простое!");
           }

        }

    }
}
