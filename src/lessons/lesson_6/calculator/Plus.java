package lessons.lesson_6.calculator;

public class Plus extends Operation{

    public Plus(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        return this.a + this.b;
    }
}
