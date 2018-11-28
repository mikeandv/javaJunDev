package lessons.chatroom;

import lessons.chatroom.db.DBWorker;
import lessons.chatroom.db.Select;
import lessons.lesson_11.homework.task1.StInput;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //DBWorker.connetTest();
        //System.out.println(Select.loginIsCheck("login"));

//        User user = new User("@karl");
//        user.createNewUser();
//        //User user1 = new User("@karl");
//        //user1.createNewUser();
//
//        UsersChat chat = new UsersChat(user);
//
//        User u = Select.getUserByLogin(StInput.read());
//        if(u != null) {
//            System.out.println(u.toString());
//        }

        DBWorker dbWorker = new DBWorker();

        try
        {
            dbWorker.getConn();
            System.out.println("success");

        } catch (SQLException e) {
            e.getMessage();
        }

    }
}
