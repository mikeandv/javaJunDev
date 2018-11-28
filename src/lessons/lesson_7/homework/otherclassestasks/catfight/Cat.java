package lessons.lesson_7.homework.otherclassestasks.catfight;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strength;

    private Cat(String name, int age, int weight, int strength) {

//        if (!nameChech(name)){
//            throw new IllegalArgumentException("Имя не введено, объект не создан");
//        }
//        if(!ageChech(age)){
//            throw new IllegalArgumentException("Возраст задан некорректно <= 0, объект не созда");
//        }
//        if(!weightChech(weight)){
//            throw new IllegalArgumentException("Вес задан некорректно <= 0, объект не создан");
//        }
//        if(!strengthChech(strength)){
//            throw new IllegalArgumentException("Сила задана некорректно <= 0, объект не создан");
//        }
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }


    public boolean fight(Cat anotherCat){
        int wins = 0;

        for (int i = 0; i < 2; i++) {
            if (score(this) > score(anotherCat)){
                wins++;
            }
        }

        return (wins == 2);
    }

    public static Cat getInstance(String name, int age, int weight, int strength){
        if (!nameChech(name)){
            System.out.println("Имя не введено, объект не создан");
            return null;
        }
        if(!ageChech(age)){
            return null;
        }
        if(!weightChech(weight)){
            return null;
        }
        if(!strengthChech(strength)){
            return null;
        }
        return new Cat(name, age, weight, strength);
    }



    private static boolean nameChech(String name) {
        if (name == "") {
            return false;
        }
        return true;
    }
    private static boolean ageChech(int age) {
        if (age <= 0) {
            return false;
        }
        return true;
    }
    private static boolean weightChech(int weight) {
        if (weight <= 0) {
            return false;
        }
        return true;
    }
    private static boolean strengthChech(int strength) {
        if (strength <= 0) {
            return false;
        }
        return true;
    }

    private int score(Cat cat) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
        return ((cat.getAge()+ cat.getWeight()) * cat.getStrength()) / randomNum;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }
    public String getName() {
        return name;
    }
}
