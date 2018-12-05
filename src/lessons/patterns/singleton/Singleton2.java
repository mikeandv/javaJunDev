package lessons.patterns.singleton;

public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2(){}

    public Singleton2 getInstance() {
        return INSTANCE;
    }
}
