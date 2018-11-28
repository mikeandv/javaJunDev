package lessons.lesson_8;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.Arrays;

public class BookHandler {

    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Book (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "title TEXT NOT NULL," +
                "pages INTEGER NOT NULL);";

        //регистрация драйвера БД
        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            //executeUpdate() используется для выполнения запросов создания изменения данных, получить данные из таблицы
            System.out.println(row);
        }
    }

    public static void insertIntoTable(Book book) throws SQLException {

        String sql = "INSERT INTO Book (title, pages)" +
                "VALUES (?, ?);";


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){

            //PreparedStatement - Подготовленный запрос
            PreparedStatement statement = connection.prepareStatement(sql);

            //Вставка занчений вместов "?"
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());

            int row = statement.executeUpdate();
            System.out.println(row);

        }
    }
    //Получение данных
    public static Book[] selectData(/*int id*/) throws SQLException {
        String sql = "SELECT * FROM Book;"; //WHERE id = ?;";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            //Book book = new Book();
            Book[] books = new Book[8];

            for (int i = 0; resultSet.next() ; i++){
                Book book = new Book();
                book.setTitle(resultSet.getString("title"));
                book.setPages(resultSet.getInt("pages"));
                books[i] = book;
            }
//            int i = 0;
//            while(resultSet.next()){
//
//                Book book = new Book();
//                book.setTitle(resultSet.getString("title"));
//                book.setPages(resultSet.getInt("pages"));
//                books[i] = book;
////                System.out.println("title = " + title);
////                System.out.println("pages = " + pages);
//                i++;
//            }
            return books;
        }
    }

    //Обновление данных в таблице
    public static void updateTable(String title, int id) throws SQLException {

        String sql = "UPDATE Book SET title = ?" +
                "WHERE id = ?;";


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")) {

            //PreparedStatement - Подготовленный запрос
            PreparedStatement statement = connection.prepareStatement(sql);

            //Вставка занчений вместов "?"
            statement.setString(1, title);
            statement.setInt(2, id);

            int row = statement.executeUpdate();
            System.out.println(row);
        }
    }


    public static void main(String[] args) {

        Book book1 = new Book("IT", 1200);
        Book book2 = new Book("RAGE", 500);

        try {
//            BookHandler.insertIntoTable(book1);
            //BookHandler.updateTable("Dog", 7);
            System.out.println(Arrays.toString(BookHandler.selectData()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
