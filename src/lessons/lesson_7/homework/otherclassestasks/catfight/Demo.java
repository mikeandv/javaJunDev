package lessons.lesson_7.homework.otherclassestasks.catfight;

public class Demo {
    public static void main(String[] args) {


//        try {
//        Cat catMiddle = new Cat("Barsik",5,6,7);
//        Cat catYong = new Cat("Gogi",1,-4,10);
//            System.out.println(catMiddle.getName() +" VS " + catYong.getName());
//            System.out.println("FIGHT!");
//
//            System.out.println(catMiddle.fight(catYong));
//
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

        Cat catMiddle = Cat.getInstance("h",5,6,7);
        if(!(catMiddle == null)) {
            System.out.println(catMiddle);
        }
    }
}
