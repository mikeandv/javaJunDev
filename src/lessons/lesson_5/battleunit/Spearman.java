package lessons.lesson_5.battleunit;

public class Spearman extends BattleUnit {

    public Spearman(int health, int attackScore, String name) {
        super(health, attackScore, name);
    }

    @Override
    public void attack(BattleUnit enemy) {
        enemy.health -= this.attackScore;
        System.out.println("Spearman " + this.name + " attack");
    }

}
