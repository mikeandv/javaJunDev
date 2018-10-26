package lessons.lesson_4.lessonwork;

public class Good {

    //Свойства атрибуты класса private атрибуты доступны только внутри класса

    private String title;
    private int price;

    //Конструктор для создания объекта без указания трибутов
    public Good() {}

    //Метод конструктор
    public Good(String title, int price) {
        this.title = title;
        this.price = price;
    }
    //Методы
    //Классы
    // void не возвращает значение
    // this работа с переменными класса

    //Сеттеры утанавливают значения атрибутов класса
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //Геттер возвращает значение атрибутов класса
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    //Переопределение метода toString (стандартный класс java) для нашего конкретного класса Good
    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
