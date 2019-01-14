package lessons.controlwork;

public class User {
    private int id;
    private String login;
    private static int count = 0;


    public User(String login) {
        this.login = login;
        this.id = count + 1;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
