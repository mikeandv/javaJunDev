package lessons.lesson_2.homework;

public class Task5 {
    public static void main(String[] args) {

        System.out.print("1 1 ");

        int firstFib = 1;
        int secondFib = 1;


        for (int i = 0; i < 15; i++) {


            int nextFib;
            nextFib = firstFib + secondFib;
            firstFib = secondFib;
            secondFib = nextFib;

            System.out.print(nextFib + " ");

        }
    }
}
