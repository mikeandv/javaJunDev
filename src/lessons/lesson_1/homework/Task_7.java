package lessons.lesson_1.homework;

public class Task_7 {
    public static void main(String[] args) {

        int a = 812;
        int n;
        int m = a;

        n = a%10;
        a /= 10;
        int max = n;

        n = a%10;
        a /= 10;
        max = (max >= n) ? max : n;

        n = a%10;
        a /= 10;
        max = (max >= n) ? max : n;

        System.out.println("В числе " + m + " наибольшая цифра " + max);
    }
}
