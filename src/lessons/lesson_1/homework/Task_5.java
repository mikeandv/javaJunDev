package lessons.lesson_1.homework;

public class Task_5 {
    public static void main(String[] args) {

        double credSum = 1_850_000;
        double rate = 9.7;
        int credPeriod = 15;

        double fullCredCost = credSum * credPeriod * (rate /100);
        double overPayment = fullCredCost - credSum;

        System.out.println("Значение переплаты по кредиту " + overPayment + " рублей");
    }
}
