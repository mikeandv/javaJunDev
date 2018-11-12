package lessons.lesson_4.homework.TaskOOP3;

import java.util.Arrays;

public class DemoLib {
    public static void main(String[] args) {

        Library libNew = new Library();
        Book boo1 = new Book(50, "Life");
        Book book2 = new Book(51, "DWH");
        Book book3 = new Book(49, "LLLF");
        System.out.println(book2.toString());

        libNew.putBook(boo1, 45);
        libNew.putBook(book3, 5);
        libNew.putBook(book2, 51);
        System.out.println(libNew.toString());
        libNew.getBook(book3, 1);
//        System.out.println("Количество книг \"" + book2.getTitle() + "\" равно " + libNew.getBookCNT(book2));
        System.out.println(libNew.toString());
//
//        Book book3 = new Book(5, "IT");
//        libNew.putBook(book3, 5);
//        System.out.println(libNew.toString());



    }


}
