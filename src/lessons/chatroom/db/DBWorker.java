package lessons.chatroom.db;

import java.sql.*;

public class DBWorker {
    protected final String connectUrl = "jdbc:mysql://localhost:3306/chat?serverTimezone=UTC";
    protected final String user = "chat_usr";
    protected final String password = "Chat_usr";


    private void connetTest() throws SQLException, ClassNotFoundException {

        try (Connection connection = DriverManager.getConnection(connectUrl, user, password)){
            System.out.println("Succes!");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
    public Connection getConn() throws SQLException{
        return DriverManager.getConnection(connectUrl, user, password);
    }

//    private String getConnectUrl() {
//        return connectUrl;
//    }
//
//    public static String getUser() {
//        return user;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
}
