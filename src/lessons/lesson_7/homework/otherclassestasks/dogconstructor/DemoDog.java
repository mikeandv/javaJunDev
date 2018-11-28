package lessons.lesson_7.homework.otherclassestasks.dogconstructor;

public class DemoDog {
    public static void main(String[] args) {
        Dog d1 = new Dog("Jack");
        Dog d2 = new Dog(6.33333, "Black Jack");
        Dog d3 = new Dog(2, "Red", "NewYork, 13 Street, 13-4");

        System.out.println(d2.toString());
        System.out.println(d3.toString());
        System.out.println(Dog.getDogCNT());
    }
}
