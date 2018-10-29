package lessons.lesson_4.homework.TaskOOP3;

import java.util.Arrays;

public class Library {
    private int bookCNTinLib;
    private Book[] book1;



    public Library() {
        this.bookCNTinLib = 100;
        this.book1 = new Book[bookCNTinLib];
    }


    public void putBook (Book book, int quantity) {

        while (quantity > 0) {
            for (int i = 0; i < this.book1.length; i++) {
                if (book1[i] != null)
                    continue;

                book1[i] = book;
                quantity--;
                break;
            }
        }
    }

    public int getBook (Book book, int quantity){

        while (quantity > 0) {
            for (int i = 0; i < this.book1.length; i++) {

                if (book1[i] == book) {
                    book1[i] = null;
                    quantity--;
                    break;
                }
            }
        }
        return getBookCNT(book);
    }

    int getBookCNT (Book book) {
        int bookCNT = 0;
        for (int i = 0; i < this.book1.length; i++){
            if (book1[i] == book)
                bookCNT++;

        }
        return bookCNT;
    }


    @Override
    public String toString() {
        return "Library{\n" + Arrays.toString(book1) +
                '}';
    }
}

