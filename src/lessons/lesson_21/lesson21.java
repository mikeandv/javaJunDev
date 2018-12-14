package lessons.lesson_21;

import java.util.ArrayList;
import java.util.List;

public class lesson21 {
    public static void main(String[] args) {
        Sync sync = new Sync();
        List<Sync.Adder> adderList = new ArrayList<>(100);

        for(int i = 0; i < 100; i++) {
        }


    }
}
class Sync {
    int counter;

    private synchronized void increment(){ //синхронизация всегда происходит по обьекту this (текущий обьект)
        counter++;
    }

    public class Adder extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 100_000; i++) {
//                counter++;
//                synchronized (Sync.this) { // можно передать отдельный объект и синхронизироваться на нем
//                    counter++;
//
//                }
                increment();

            }
        }
    }
}

class Storage {
    int goodsCount = 0;

    public synchronized void getGood() throws InterruptedException {
        System.out.println("getGood start");

        while(goodsCount < 1) {
            wait();
        }

        goodsCount--;

        System.out.println("Take one good from lib");
        System.out.println("In lib remains " + goodsCount + " good");

        notify();// notifyAll() - разбудит все ожидающие потоки
        System.out.println("getGood finish");
    }

    public synchronized void putGood() throws InterruptedException {
        System.out.println("putGood start");
        while(goodsCount >= 5) {
            wait();
        }

        goodsCount++;
        System.out.println("Good is put in lib");
        System.out.println("In lib remains " + goodsCount + " good");

        notify();
        System.out.println("putGood finish");
    }
}

class Put implements Runnable {

    Storage storage;

    public Put(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            try {
                storage.putGood();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Get implements Runnable {
    Storage storage;

    public Get(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        for (int i = 1; i < 10; i++) {
            try {
                storage.getGood();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Library {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Put put = new Put(storage);
        Get get = new Get(storage);

        new Thread(put).start();
        new Thread(get).start();

    }
}
