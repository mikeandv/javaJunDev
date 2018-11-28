package lessons.lesson_7.homework.otherclassestasks.pointaffil;

public class ResultCalc {
    private int x;
    private int y;

    private ResultCalc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void checkPoint() {
        ResultCalc r = new ResultCalc(InDataScanner.readFromInput(), InDataScanner.readFromInput());

        if (r.x > 0 && r.y > 0)
            System.out.println("1");
        if (r.x < 0 && r.y > 0)
            System.out.println("2");
        if (r.x < 0 && r.y < 0)
            System.out.println("3");
        if (r.x > 0 && r.y < 0)
            System.out.println("4");

    }

}
