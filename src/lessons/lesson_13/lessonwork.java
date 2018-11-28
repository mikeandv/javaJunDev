package lessons.lesson_13;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class lessonwork {
    static String connectUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    static String user = "root";
    static String password = "ytnckjd1988@";



    public static void createTable() throws SQLException, ClassNotFoundException {

        String sql = "CREATE TABLE IF NOT EXISTS Example " +
                "(id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                "firstColumn VARCHAR(20) NOT NULL, " +
                "secondColumn INTEGER NOT NULL);";

        //регистрация драйвера БД
        //DriverManager.registerDriver(new JDBC());
        //Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectUrl, user, password)){
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            //executeUpdate() используется для выполнения запросов создания изменения данных, получить данные из таблицы


            System.out.println(row);

        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        lessonwork.createTable();
    }



}
