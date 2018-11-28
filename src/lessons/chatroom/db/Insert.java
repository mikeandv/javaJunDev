package lessons.chatroom.db;

import lessons.chatroom.User;
import lessons.chatroom.UsersChat;

import java.sql.*;

public class Insert extends DBWorker {


//    public Insert() {
//        this.statementStr = statementStr;
//    }

//    public static boolean addNewUser(User user) {
//
//        String sql = "INSERT INTO USER (NAME, STATUS, LOGIN)" +
//                "VALUES ('" + user.getName() + "', '" + user.getStatus() + "', '"+ user.getLogin() + "');";
//
//        try (Connection connection = DriverManager.getConnection(, DBWorker.getUser(), DBWorker.getPassword())) {
//            Statement statement = connection.createStatement();
//            int row = statement.executeUpdate(sql);
//            if(row == 1)
//                return true;
//
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        return false;
//    }

//    public static boolean addNewChat(UsersChat chat) {
//
//        String sql = "INSERT INTO USERS_CHAT (NAME, ADMIN_ID)" +
//                "VALUES (?, ?);";
//
//        try (Connection connection = DriverManager.getConnection(DBWorker.getConnectUrl(), DBWorker.getUser(), DBWorker.getPassword())) {
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, chat.getName());
//            preparedStatement.setInt(2, chat.getAdminId());
//
//
//            int row = preparedStatement.executeUpdate(sql);
//            if(row == 1)
//                return true;
//
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        return false;
//    }


}
