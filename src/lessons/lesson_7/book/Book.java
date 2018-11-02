package lessons.lesson_7.book;

import java.util.Objects;
import java.util.Random;

public class Book {

    final String CONST;// = "Str";     //Константа, значение присваивается либо сразу либо в конструкторе
                                        //Так же можно создадать ее статической
                                        // final в применении к методу запрещает его переопределние
                                        // final в применении к классу запрещает классу иметь наследнико
                                        // final в качестве аргумента в вызове метода запрещает этот аргумент изменять, т.е. он доступен только для чтения

    private String title;
    private String author;
    int pages;

    public static int soldBook; // статические свойста(переменные, методы,классы) это свойста класса, а не объекта

    static {
        soldBook = - (new Random().nextInt(100));
    }

    public void sellBook(){
        soldBook++;
    }

    public static String getStatistics(){
        return "Stat" + soldBook;
        // В статических методах можно использовать только статсические переменные
        // Так же нельзя вызывать нестатические методы в статических.
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        CONST = "String";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // Все классы наследуют от Object
    // toString()
    // clone() - Возвращает копию объекта
    // getClass() - Возвращает ссылку на клас объекта
    // finalize() - используется при работе сборщика мусора
    // wait() | notify() | notifyAll() - используется в многопоточности
    // equals() - возвращает true или false при сравнении объектов По умолчанию сравнивется как ==
    // hashCode() - возвращает hashCode объекта

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }
}