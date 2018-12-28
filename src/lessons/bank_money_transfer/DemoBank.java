package lessons.bank_money_transfer;

public class DemoBank {

    public static void main(String[] args) {
        Bank bank = new Bank();

        User u1 = new User("fff@mail.com");
        User u2 = new User("rafl@mail.com");

        bank.createAccount(new Account(u1.getId()));
        bank.createAccount(new Account(u1.getId()));
        bank.createAccount(new Account(u2.getId()));
        bank.createAccount(new Account(u2.getId()));
        bank.createAccount(new Account(u2.getId()));


        bank.getAccountById(1).setAmount(1000);
        bank.getAccountById(3).setAmount(2000);


        System.out.println(bank.getAccountById(1).toString());
        System.out.println(bank.getAccountById(3).toString());

        bank.transferMoney(bank.getAccountById(1), bank.getAccountById(3), 500);
        bank.transferMoney(bank.getAccountById(3), bank.getAccountById(1), 1000);



        for (Thread t : bank.getThreads()) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(bank.getAccountById(1).toString());
        System.out.println(bank.getAccountById(3).toString());

    }
}
