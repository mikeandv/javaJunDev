package lessons.thread_blockin_q_hm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TBlockingDemo {
    BlockingQueue<Order> newOrderQ = new ArrayBlockingQueue<>(15, true);
    BlockingQueue<Order> cokedOrderQ = new ArrayBlockingQueue<>(10, true);
    BlockingQueue<Order> doneOrderQ = new ArrayBlockingQueue<>(5, true);
    boolean isWork = true;

    public static void main(String[] args) {
        TBlockingDemo tbDemo = new TBlockingDemo();

        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();
        new Thread(new Waiter(tbDemo)).start();

        new Thread(new Cooker(tbDemo)).start();
        new Thread(new Cooker(tbDemo)).start();


        for (int i = 0; i < 50; i++){

            new Thread(new Client(tbDemo, String.valueOf(i))).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
