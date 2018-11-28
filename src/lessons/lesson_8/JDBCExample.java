package lessons.lesson_8;

import org.sqlite.JDBC;

import java.sql.*;


public class JDBCExample {

    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Example " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL " +
                "firstColumn TEXT NOT NULL " +
                "secondColumn INTEGER NOT NULL);";

        //регистрация драйвера БД
        DriverManager.registerDriver(new JDBC());

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
                    //executeUpdate() используется для выполнения запросов создания изменения данных, получить данные из таблицы


            System.out.println(row);

        }
    }
    //Вставка данных в таблицу
    public static void insertIntoTable() throws SQLException {

        String sql = "INSERT INTO Example (firstColumn, secondColumn)" +
                "VALUES ('Value1', 123)," +
                        " ('Value2', 456);";


        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);

            System.out.println(row);
        }
    }

    //Получение данных
    public static void selectData() throws SQLException {
        String sql = "SELECT * FROM Example WHERE id = 1;";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db")){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String str = resultSet.getString("firstColumn");
                int i = resultSet.getInt("secondColumn");
                System.out.println("str = " + str);
                System.out.println("i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        try {
//            JDBCExample.insertIntoTable();
            JDBCExample.selectData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
