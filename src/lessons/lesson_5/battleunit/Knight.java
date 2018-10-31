package lessons.lesson_5.battleunit;

    public class Knight extends BattleUnit implements ISpeakerUnit{

        public Knight(int health, int attackScore, String name) { // 100 20
            super(health, attackScore, name); // 100 20
        }

        private void addHealth(){
            if (this.health > 1) {
                this.health +=5;
            }
        }

        @Override
        public void attack(BattleUnit enemy){
            enemy.health -= this.attackScore;
            addHealth();
            System.out.println("Knight " + this.name + " attack");
        }

        @Override
        public void say(String text) {
            System.out.println(this.name + ": " + text);

        }

        @Override
        public void sing(String song) {

        }
    }
