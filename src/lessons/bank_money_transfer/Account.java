package lessons.bank_money_transfer;

public class Account {
    private static int count = 0;
    private int id;
    private int userId;
    private double amount;

    public Account(int userId) {
        this.id = ++count;
        this.userId = userId;
        this.amount = 0;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}
