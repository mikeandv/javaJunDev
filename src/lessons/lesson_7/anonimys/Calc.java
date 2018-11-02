package lessons.lesson_7.anonimys;

public class Calc {
    private int a;
    private int b;

    public Calc (int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double summ(Operation operation){
        return operation.appy(a, b);
    }
}
