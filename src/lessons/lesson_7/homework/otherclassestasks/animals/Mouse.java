package lessons.lesson_7.homework.otherclassestasks.animals;

public class Mouse implements Movable, Eatable{
    private boolean isEaten = false;

    @Override
    public boolean isEatable() {
        if (isEaten == true) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean move(String direction, int range) {
        if(isEaten == true) {
            return false;
        } else {
            return true;
        }
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }
}
