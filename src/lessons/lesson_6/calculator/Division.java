package lessons.lesson_6.calculator;

public class Division extends Operation {

    public Division(int a, int b) {
        super(a, b);
    }

    @Override
    public double execute() {
        if (this.b == 0) {
            System.out.println("Ошибка деления на ноль");
            return 0;
        }
        return this.a / this.b;
    }

}
