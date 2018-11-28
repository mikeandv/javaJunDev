package lessons.lesson_7.homework.otherclassestasks.animals;

public class Dog implements Movable, Eat, Eatable {
    private String name;
    private String breed;


    @Override
    public boolean move(String direction, int range) {
        return true;
    }

    @Override
    public boolean eatAnotherAnimal(Object animal) {
        if ((animal instanceof Mouse) && ((Mouse) animal).isEatable()) {
            ((Mouse) animal).setEaten(true);
            return true;
        } else if ((animal instanceof Cat) && ((Cat) animal).isEatable()) {
                    ((Cat) animal).setEaten(true);
            return true;
        } else  if ((animal instanceof Dog) && ((Dog) animal).isEatable()){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean isEatable() {
        return false;
    }
}
