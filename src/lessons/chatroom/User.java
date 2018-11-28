package lessons.chatroom;

import lessons.chatroom.db.Insert;
import lessons.chatroom.db.Select;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String name;
    private String status = "offline";// TODO: 21.11.2018  исправить
    private String login;

//    public User(String name, String login) {
//
//        this.name = name;
//        this.setLogin(login);
//    }

//    public User(String login) {
//        try {
//            this.setLogin(login);
//        } catch (IllegalArgumentException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        this.name = this.login;
//    }

    public User(int userId, String name, String status, String login) {
        this.userId = userId;
        this.name = name;
        this.status = status;
        this.login = login;
    }

//    public boolean createNewUser() {
//        if (getLogin() == null)
//            return false;
//        return Insert.addNewUser(this);
//        // TODO: 21.11.2018  изменить добавить логику
//    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

//    public void setLogin(String login) {
//        if(Select.loginIsCheck(login)) {
//            this.login = login;
//        } else {
//            throw new IllegalArgumentException("duplicate login");
//        }
//    }

//    public static User getInstance(String login) throws SQLException {
//
//        ResultSet rs = Select.getUserByLogin(login);
//        if(rs == null) {
//            return null;
//        }
//
//        User u = new User(rs.getInt(1), rs.getString(2),
//                rs.getString(3), rs.getString(4));
//
//        return u;
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
