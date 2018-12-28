package lessons.bank_money_transfer;

import java.util.Date;
import java.util.concurrent.Callable; // для версии работы с экзекутором

public class Transaction implements /*Callable<Boolean>*/ Runnable {
    private final Account src;
    private final Account dst;
    private Bank bank;
    private final double amount;
    private Date date;
    private boolean tranSucces;


    public Transaction(Account src, Account dst, Bank bank, double amount) {
        this.src = src;
        this.dst = dst;
        this.bank = bank;
        this.amount = amount;
        this.date = new Date();
        this.tranSucces = false;


    }

    private boolean acceptTransfer() {
        if (src.getAmount() <= 0
                || src.getAmount() < amount
                || amount <= 0
                || (src.getId() == dst.getId())) {
            return false;
        }

        src.setAmount(src.getAmount() - amount);
        dst.setAmount(dst.getAmount() + amount);
        return true;
    }

    @Override
    public void run() {
        boolean res;

        if(src.getId() > dst.getId()) {
            synchronized (src) {
                synchronized (dst) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    res = acceptTransfer();
                    if (res) {
                        System.out.println("Transaction success");
                    } else {
                        System.out.println("Transaction failed");
                    }
                }
            }
        } else if(dst.getId() > src.getId()) {
            synchronized (dst) {
                synchronized (src) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    res = acceptTransfer();
                    if (res) {
                        System.out.println("Transaction success");
                    } else {
                        System.out.println("Transaction failed");
                    }
                }
            }
        }
    }

//    @Override //Нужно ли при использовании экзекутора делать синхронизации на обьектах или оно автоматически будет синхронизироваться.
    //добиться блокировки у меня не получилось
//    public Boolean call() {
//
//        if(src.getId() > dst.getId()) {
//            synchronized (src) {
//                synchronized (dst) {
//                    return acceptTransfer();
//                }
//            }
//        } else if(dst.getId() > src.getId()) {
//            synchronized (dst) {
//                synchronized (src) {
//                   return acceptTransfer();
//                }
//            }
//        } else {
//            return false;
//        }
//    }

}
