package lessons.lesson_5.battleunit;

public interface ISpeakerUnit {

    void say(String text);
    void sing(String song);

    default void greeting() {
        //default метод с реализацией
        System.out.println("Hello");
    }
}
