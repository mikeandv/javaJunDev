package lessons.thread_blockin_q_hm;

import java.util.concurrent.BlockingQueue;

public class Client implements Runnable{
    BlockingQueue<Order> newOrderQ;
    BlockingQueue<Order> doneOrderQ;
    private Order order;
    boolean isWork;


    public Client(TBlockingDemo tb, String orderName) {
        this.newOrderQ = tb.newOrderQ;
        this.doneOrderQ = tb.doneOrderQ;
        this.order = new Order(orderName);
        this.isWork = tb.isWork;

    }

    @Override
    public void run() {
        try {
            newOrderQ.put(order);
            System.out.println("new order" + order.getName());

            while(isWork) {
                if (doneOrderQ.contains(order)) {
                    doneOrderQ.take();
                    System.out.println("Order is taken" + order.getName());
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
