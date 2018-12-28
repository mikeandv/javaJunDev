package lessons.bank_money_transfer;

public class User {
    private int id;
    private static int count = 0;
    private String email;

    public User(String email) {
        this.id = ++count;
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
