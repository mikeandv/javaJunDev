package lessons.lesson_7.homework.otherclassestasks.animals;

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        Mouse m = new Mouse();
        Dog d = new Dog();
        Dog d1 = new Dog();
        Object j = new Object();
        System.out.println(c.eatAnotherAnimal(m));
        System.out.println(c.eatAnotherAnimal(m));
        System.out.println(d.eatAnotherAnimal(d1));
        System.out.println(d.eatAnotherAnimal(m));


    }
}
