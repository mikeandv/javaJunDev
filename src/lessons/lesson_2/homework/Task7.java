package lessons.lesson_2.homework;

public class Task7 {
    public static void main(String[] args) {

        int simHourCNT = 0;

        outer: for (int h1 = 0; h1 < 3; h1++) {
            for (int h2 = 0; h2 < 10; h2++) {

                // выход из цикла при 24:00
                if ((h1 == 2) && (h2 == 4)) {
                   break outer;
                }

                for (int m1 = 0; m1 < 6; m1++) {
                    for (int m2 = 0; m2 < 10; m2++) {

                        //System.out.println(h1 + "" + h2 + ":" + m1 + "" + m2);

                        //подсчет количества зеркальных комбинаций

                        if ((h1 == m2) && (h2 == m1)) {
                            simHourCNT++;
                            //System.out.println(h1 + "" + h2 + ":" + m1 + "" + m2);
                        }
                    }
                }
            }
        }

        // Вывод количества симметричных комбинаций
        System.out.println(simHourCNT);
    }
}
