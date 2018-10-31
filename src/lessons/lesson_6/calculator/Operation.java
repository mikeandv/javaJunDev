package lessons.lesson_6.calculator;

abstract public class Operation {

    protected int a;
    protected int b;

    public Operation(int a, int b) {

        this.a = a;
        this.b = b;
    }

    abstract public double execute();

}
