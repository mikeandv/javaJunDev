package lessons.controlwork;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String dbURL = "jdbc:sqlite:dao2.db";

    public DBConnection() throws SQLException {
        DriverManager.registerDriver(new JDBC());
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL);
    }
}

//    public void execStatement(String query) {
//
//        try(Connection connection = DriverManager.getConnection(dbURL)) {
//            Statement statement = connection.createStatement();
//            int row = statement.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void execPreparedStatement(String query, )
//}
