package lessons.lesson_4.homework.TaskOOP1;


public class Main {
    public static void main(String[] args) {

        Rectangle rectOne = new Rectangle();
        System.out.println(rectOne.toString());
        System.out.println(rectOne.square());
        System.out.println(rectOne.perimeter());

        Triangle triangleOne = new Triangle();
        System.out.println(triangleOne.toString());
        System.out.println(triangleOne.square());
        System.out.println(triangleOne.perimeter());

        Circle circleOne = new Circle();
        System.out.println(circleOne.toString());
        System.out.println(circleOne.gfd(0,1));
        System.out.println(circleOne.square());
        System.out.println(circleOne.perimeter());



    }
}
