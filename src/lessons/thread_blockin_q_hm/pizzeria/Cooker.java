package lessons.thread_blockin_q_hm.pizzeria;

import java.util.concurrent.BlockingQueue;

public class Cooker implements Runnable{
    BlockingQueue cokedOrderQ;
    BlockingQueue doneOrderQ;
    Order order;
    boolean isWork = true;

    public Cooker(TBlockingDemo tb) {
        this.cokedOrderQ = tb.cokedOrderQ;
        this.doneOrderQ = tb.doneOrderQ;
    }

    @Override
    public void run() {
        while(isWork) {

            try {
                order = (Order) cokedOrderQ.take();
                if(order.getName().equals("exit")) {
                    isWork = false;
                    break;
                }
                Thread.sleep(5000);
                doneOrderQ.put(order);
                System.out.println("cooket 1 order" + order.getName());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Повар ушел домой");
    }
}
