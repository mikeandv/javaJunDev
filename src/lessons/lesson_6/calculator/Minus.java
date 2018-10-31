package lessons.lesson_6.calculator;

public class Minus extends Operation {

    public Minus(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return this.a - this.b;
    }
}
