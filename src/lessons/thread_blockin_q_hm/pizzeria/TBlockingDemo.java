package lessons.thread_blockin_q_hm.pizzeria;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TBlockingDemo {
    BlockingQueue<Order> newOrderQ = new ArrayBlockingQueue<>(15, true);
    BlockingQueue<Order> cokedOrderQ = new ArrayBlockingQueue<>(10, true);
    BlockingQueue<Order> doneOrderQ = new ArrayBlockingQueue<>(5, true);

    public static void main(String[] args) {
        TBlockingDemo tbDemo = new TBlockingDemo();

        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();

        new Thread(new Cooker(tbDemo)).start();
        new Thread(new Cooker(tbDemo)).start();


        for (int i = 0; i < 20; i++){

            new Thread(new Client(tbDemo, String.valueOf(i))).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tbDemo.exit();
    }

    public void exit() {
        try {

            newOrderQ.put(new Order("exit"));
            newOrderQ.put(new Order("exit"));
            newOrderQ.put(new Order("exit"));
            newOrderQ.put(new Order("exit"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
