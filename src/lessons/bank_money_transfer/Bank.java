package lessons.bank_money_transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException; // сделал вариант работы еще и с экзекутором
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bank {
    private List<Account> userAccounts = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public List<Thread> getThreads() {
        return threads;
    }

    public /*boolean*/void transferMoney(Account src, Account dst, double amount) {
//        Это варинт метода с использованием экзекутора
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Transaction tr = new Transaction(src, dst,this, amount);
//        Boolean res = false;
//
//        try {
//            res = executor.submit(tr).get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        executor.shutdown();
//
//        if(res) {
//            System.out.println("Transaction success");
//            return res;
//        } else {
//            System.out.println("Transaction failed");
//            return res;
//        }
        Transaction tr = new Transaction(src, dst,this, amount);
        Thread t = new Thread(tr);
        t.start();

        threads.add(t);
    }

    public void createAccount(Account a){
        userAccounts.add(a);
    }

    public Account getAccountById(int accId) {
        for (Account a : this.userAccounts) {
            if(a.getId() == accId)
                return a;
        }
        return null;
    }

    public List<Account> getUserAccount(int userId) {
        List<Account> tmp = new ArrayList<>();

        for(Account a : this.userAccounts) {
            if(a.getUserId() == userId)
                tmp.add(a);
        }
        return tmp;
    }
}
