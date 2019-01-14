package lessons.controlwork;

import java.sql.*;

public class UserDao implements Dao {
    DBConnection dbConnection;
    User user;
    String insert = "INSERT INTO User (id, login) VALUES (?, ?);";
    String getAll = "SELECT * FROM User;";
    String getById = "SELECT * FROM User WHERE id=?;";
    String update = "UPDATE User SET login=? WHERE id=?";
    String delete = "DELETE FROM User WHERE id=?;";


    public UserDao(DBConnection conn) {
        this.dbConnection = conn;
        checkIfExist();

    }

    public void setUser(User u) {
        this.user = u;
    }

    private void checkIfExist() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "login TEXT NOT NULL);";

        try (Connection connection = dbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);

            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add() {

            try(Connection connection = dbConnection.getConnection()) {

                //PreparedStatement - Подготовленный запрос
                PreparedStatement statement = connection.prepareStatement(insert);

                //Вставка занчений вместов "?"
                statement.setInt(1, user.getId());
                statement.setString(2, user.getLogin());

                int row = statement.executeUpdate();
                System.out.println(row);

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void getAll() {
        try(Connection connection = dbConnection.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAll);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String str = resultSet.getString("login");
                System.out.println("id: " + id + " login: " + str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getById() {

    }
}
