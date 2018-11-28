package lessons.lesson_7.homework.otherclassestasks.bodymassindex;

import java.util.Scanner;

public class Body {
    private double weight;
    private double height;
    private Scanner s = new Scanner(System.in);

    private Body(){

        System.out.println("Введите рост: ");
        this.setHeight();
        if(this.height == 0){
            System.out.println("Введен некорректный рост!\nВыход из программы");
            return;
        }

        System.out.println("Введите вес: ");
        this.setWeight();
        if(this.weight == 0){
            System.out.println("Введен некорректный вес!\nВыход из программы");
            return;
        }
    }

    public void setWeight() {
        double d = s.nextDouble();
        // TODO: 14.11.2018  добавить проверку на ввод строки
        if(d <= 0) {
            return;
        }
        this.weight = d;
    }

    public void setHeight() {
        double d = s.nextDouble();
        // TODO: 14.11.2018  добавить проверку на ввод строки
        if(d <= 0){
            return;
        }
        this.height = d;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public static void bodyIndexCalc(){

        Body b = new Body();

        double res = b.getWeight() / ((b.getHeight() * b.getHeight()));

        if (res < 18.5) {
            System.out.println("Недовес: меньше чем 18.5");
        } else if((res >=18.5) && (res <= 24.9)) {
            System.out.println("Нормальный: между 18.5 и 24.9");
        } else if((res >= 25) && (res <= 29.9)) {
            System.out.println("Избыточный вес: между 25 и 29.9");
        } else {
            System.out.println("Ожирение: 30 или больше");
        }
    }
}
