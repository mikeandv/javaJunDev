package lessons.lesson_7.homework.otherclassestasks.objdef;

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();
        Bird b = new Bird();
        objDefinition(c);
        objDefinition(d);
        objDefinition(b);
    }

    public static void objDefinition(Object obj) {
        if (obj instanceof Cat) {
            System.out.println("Кошка");
        }
        if (obj instanceof Dog) {
            System.out.println("Собака");
        }
        if (obj instanceof Bird) {
            System.out.println("Птица");
        }
    }
}
