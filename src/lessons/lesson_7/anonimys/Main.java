package lessons.lesson_7.anonimys;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc(3, 6);
        calc.summ(new Operation() {
            @Override
            public double appy(double var1, double var2) {
                return 0;
            }
        });
    }
}
