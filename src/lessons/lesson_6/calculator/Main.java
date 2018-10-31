package lessons.lesson_6.calculator;

public class Main {
    public static void main(String[] args) {
        int a = 9;
        int b = 0;

        Operation plus = new Plus (a, b);
        System.out.println(plus.execute());

        Operation minus = new Minus (a, b);
        System.out.println(minus.execute());

        Operation multiply = new Multiply(a, b);
        System.out.println(multiply.execute());

        Operation division = new Division(a, b);
        System.out.println(division.execute());

    }

}
