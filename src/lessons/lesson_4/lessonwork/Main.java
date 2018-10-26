package lessons.lesson_4.lessonwork;

public class Main {
    public static void main(String[] args) {

        Good table = new Good(); // Создание объекта с типом Good
        table.setTitle("Стол");
        table.setPrice(800);

        Good door = new Good("Дверь", 1200);

        //System.out.println(table.toString()); //Вызов переопределенного метода toString()
        //System.out.println(table.getPrice());

        Good chair = new Good(); // Создание объекта с типом Good
        chair.setTitle("Стул");
        chair.setPrice(50);

        //System.out.println(table.toString());
        //System.out.println(chair.toString());

        //Создание объекта с типом Storage
        Storage storage = new Storage();

        storage.addGoods(chair);
        storage.addGoods(table);
        storage.addGoods(chair);
        //storage.addGoods(chair);
        storage.showGoods();
        //storage.



    }
}
