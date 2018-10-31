package lessons.lesson_5.battleunit;

public class Doctor  extends BattleUnit implements ISpeakerUnit{

    public Doctor(int health, int attackScore, String name) {
        super(health, attackScore, name);
    }
    private void addHealth() {
        if (this.health > 1) {
            this.health += 5;
        }
    }

    @Override
    public void attack (BattleUnit enemy){
            addHealth();
        System.out.println("Doctor " + this.name + " heal " + enemy.name);
    }

    @Override
    public void say(String text) {
        System.out.println(this.name + ": " + text);
    }

    @Override
    public void sing(String song) {
        System.out.println(song);


    }
}

