package lessons.lesson_5.battleunit;

abstract public class BattleUnit {
    //    private int health;
//    private int attackScore;
    protected int health;
    protected int attackScore;
    protected String name;


    public BattleUnit(int health, int attackScore, String name) { // 100 20
        this.health = health;
        this.attackScore = attackScore;
        this.name = name;
    }

    public boolean isAlive(){
        return health > 0;
    }

//    public void attack(BattleUnit enemy){
//        enemy.health -= this.attackScore;
//        System.out.println("BattleUnit attack");
//    }
    abstract public void attack(BattleUnit enemy);

}
