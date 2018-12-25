package lessons.thread_blockin_q_hm;

import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable{
    BlockingQueue newOrderQ;
    BlockingQueue cokedOrderQ;
    Order order;
    boolean isWork;


    public Waiter(TBlockingDemo tb) {
        this.newOrderQ = tb.newOrderQ;
        this.cokedOrderQ = tb.cokedOrderQ;
        this.isWork = tb.isWork;
    }

    @Override
    public void run() {
        while(isWork) {
            try {
                order = (Order) newOrderQ.take();
                Thread.sleep(3000);
                cokedOrderQ.put(order);
                System.out.println("order take" + order.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
