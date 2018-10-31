package lessons.lesson_6.calculator;

public class Multiply extends Operation{

    public Multiply(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return this.a * this.b;
    }
}
