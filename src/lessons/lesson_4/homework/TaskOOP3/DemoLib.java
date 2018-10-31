package lessons.lesson_4.homework.TaskOOP3;

import java.util.Arrays;

public class DemoLib {
    public static void main(String[] args) {

        Library libNew = new Library();
        Book boo1 = new Book(1, "Life");
        Book book2 = new Book(3, "DWH");
        System.out.println(book2.toString());

        libNew.putBook(boo1, 3);
        libNew.putBook(book2, 2);

        System.out.println(libNew.toString());
        libNew.getBook(book2, 1);
        System.out.println("Количество книг \"" + book2.getTitle() + "\" равно " + libNew.getBookCNT(book2));
        System.out.println(libNew.toString());

        Book book3 = new Book(5, "IT");
        libNew.putBook(book3, 5);
        System.out.println(libNew.toString());



    }


}
