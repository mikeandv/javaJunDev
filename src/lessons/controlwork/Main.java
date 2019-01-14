package lessons.controlwork;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        DBConnection dbConnection = null;

        try {
            dbConnection = new DBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao(dbConnection);

//        userDao.setUser(new User("cat"));
//        userDao.add();
//
//        userDao.setUser(new User("dog"));
//        userDao.add();
        userDao.getAll();
    }
}
