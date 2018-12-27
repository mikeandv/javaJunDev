package lessons.concurrent_homework.habor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class HarborDemo {
    static BlockingQueue<Ship> harbor = new ArrayBlockingQueue<>(4, true);
    private List<Thread> docks = new ArrayList<>();

    public HarborDemo(int docksCount) {
        for (int i = 0; i < docksCount; i++) {
            docks.add(new Thread(new Dock("DK-" + i)));
        }
    }

    public static void main(String[] args) {

        HarborDemo harborDemo = new HarborDemo(4);
        harborDemo.dockStart();

        for(int i = 0;i < 5;i++) {
            harborPut(new Ship(5, 7));
        }

        harborDemo.finishWork();
        System.out.println("Work is over");
    }






    public void dockStart() {
        for(Thread t : this.docks) {
            t.start();
        }
    }
    public void finishWork() {
        for(Thread t : this.docks) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void harborPut(Ship s) {
        try {
            harbor.put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Ship harborTake() throws InterruptedException{
            return harbor.poll(5, TimeUnit.SECONDS);
    }
}
