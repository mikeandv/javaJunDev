package lessons.chatroom.db;

import lessons.chatroom.User;
import lessons.lesson_6.homework.linkedlist.List;

import java.sql.*;

public class Select extends DBWorker {

//    public boolean loginIsCheck(String login) {
//
//        String sql = "SELECT USER_ID FROM USER WHERE LOGIN = '" + login + "';";
////        int row = 0;
//
//        Select s = new Select();
//
//        DBWorker db = new DBWorker();
//        try(db.getConn()) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet= statement.executeQuery(sql);
//
//            if(resultSet.next())
//                return false;
//
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        return true;
//    }

//    public static  getUserChat(User user) {
//
//        String sql = "SELECT CHAT_ID FROM USER_IN_CHAT WHERE USER_ID = ?;";
////        int row = 0;
//
//        try (Connection connection = DriverManager.getConnection(DBWorker.getConnectUrl(), DBWorker.getUser(), DBWorker.getPassword())) {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, user.getUserId());
//            ResultSet resultSet= preparedStatement.executeQuery(sql);
//
//            if(resultSet.next())
//                return null;
//
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        return ;
//    }
//
//    public static User getUserByLogin(String login) {
//
//        String sql = "SELECT USER_ID, NAME, STATUS, LOGIN " +
//                                    "FROM USER WHERE LOGIN = ?;";
//        User u = null;
//        try (
//                Connection connection = DriverManager.getConnection(
//                DBWorker.getConnectUrl(),
//                DBWorker.getUser(),
//                DBWorker.getPassword())
//        )
//        {
//
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, login);
//            System.out.println(ps.toString());
//            ResultSet resultSet = ps.executeQuery();
//
//            while (resultSet.next()) {
//
//                u = new User(resultSet.getInt(1), resultSet.getString(2),
//                        resultSet.getString(3), resultSet.getString(4));
//            }
//        }  catch (SQLException e) {
//                System.out.println("ERROR: " + e.getMessage());
//        }
//
//        return u;
//
//    }





}
