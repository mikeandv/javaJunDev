package lessons.lesson_1.lessonwork;

public class Task1 {
    public static void main(String[] args) {

    int a = -6;
    int b = -9;
    int c = 8;
/////


        if ((a < b) && (a < c)) {
        System.out.print(a);
        if (b < c) {
            System.out.print(", "+ b + ", "+ c);
        } else {
            System.out.print(", "+ c + ", "+ b);
        }
    }
        else if ((b < c) && (b < a)) {
        System.out.print(b);
        if (c < a) {
            System.out.print(", "+ c + ", "+ a);
        } else {
            System.out.print(", "+ a + ", "+ c);
        }
    }
        else {
            System.out.print(c);
            if (a < b) {
                System.out.print(", " + a + ", " + b);
            } else {
                System.out.print(", " + b + ", " + a);
            }
        }
    }





}
