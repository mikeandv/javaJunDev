package lessons.thread_blockin_q_hm.pizzeria;

import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable{
    BlockingQueue newOrderQ;
    BlockingQueue cokedOrderQ;
    Order order;
    boolean isWork = true;


    public Waiter(TBlockingDemo tb) {
        this.newOrderQ = tb.newOrderQ;
        this.cokedOrderQ = tb.cokedOrderQ;
    }

    @Override
    public void run() {

        while(isWork) {
            try {

                order = (Order) newOrderQ.take();
                if(order.getName().equals("exit")) {
                    isWork = false;
                    cokedOrderQ.put(order);
                    break;
                }
                Thread.sleep(3000);
                cokedOrderQ.put(order);
                System.out.println("order take" + order.getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Официант закончил");
    }
}
