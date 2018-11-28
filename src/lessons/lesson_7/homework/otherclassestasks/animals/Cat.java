package lessons.lesson_7.homework.otherclassestasks.animals;

public class Cat implements Movable, Eatable, Eat {
    private String name;
    private String breed;
    private boolean isEaten = false;

    @Override
    public boolean move(String direction, int range) {
        if(isEaten == true) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean eatAnotherAnimal(Object animal) {
        if ((animal instanceof Mouse) && ((Mouse) animal).isEatable()) {

            ((Mouse) animal).setEaten(true);
            return true;

        } else if ((animal instanceof Cat) && ((Cat) animal).isEatable()) {
                    ((Cat) animal).setEaten(true);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEatable() {
        if (isEaten == true) {
            return false;
        } else {
            return true;
        }
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }
}
