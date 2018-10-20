package lessons.lesson_2.homework;

public class Task4 {
    public static void main(String[] args) {

        int a = 8;
        int n = 11;
        //double res = (Math.pow(a, (p-1)) );
        //double ff = res % a;


        for (int i = 0; i < 100; i++) {


            if ((a % n) == 0) {
                continue;
            }
            double res = (Math.pow(a, (n-1)) ) % n;


            if ( ( (Math.pow(a, (n-1)) ) % n) != 1 ) {
                System.out.println("Число составное");
                break;


            }
        }
//
//
//        if ( ( (Math.pow(a, (n-1)) ) % a) != 1 ) {
//            System.out.println("Число составное");
//
//        }
//
//        System.out.println(4%497);
//
//        int b = 4;
//        int n = 13;
//        int m = 497;
//        int c = 1;
//
//
//        for (int i = 1; i <= n; i++) {
//
//            c = (c * b) % m;
//
//        }
//        System.out.println(c);
    }
}
