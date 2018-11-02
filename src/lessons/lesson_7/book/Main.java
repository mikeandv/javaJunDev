package lessons.lesson_7.book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("this book", "King");
        book1.setPages(500);

        Book book2 = new Book("this book", "King");
        book2.setPages(500);

        System.out.println(book1.toString());
        System.out.println(book2.toString());

        System.out.println(book1 == book2);         // false
        System.out.println(book1.equals(book2));    // false
        System.out.println(Book.getStatistics());

        book2.sellBook();
        System.out.println(Book.getStatistics());

    }
}
