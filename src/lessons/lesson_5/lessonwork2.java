package lessons.lesson_5;

import lessons.lesson_5.battleunit.Knight;
import lessons.lesson_5.battleunit.Spearman;
import lessons.lesson_5.battleunit.Doctor;

public class lessonwork2 {
    public static void main(String[] args) {

        Knight knight = new Knight(100, 20, "Дрю");
        Spearman spearman = new Spearman(60, 70,"Джава лорд");
        Doctor doctor = new Doctor(50,10, "Арман");

        knight.attack(spearman);
        knight.say("Кек");

        spearman.attack(knight);
        knight.say("Каналья!!");

        doctor.say("Im doctor and i heal you!");
        doctor.attack(knight);
    }

    //

}
