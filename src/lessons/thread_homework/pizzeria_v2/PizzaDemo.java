package lessons.thread_homework.pizzeria_v2;

import java.util.ArrayList;
import java.util.List;

public class PizzaDemo {
    private final List<Client> newClient;
    private final List<Order> orders;
    private final List<Order> doneOrder;
    private boolean isWork = true;



    public PizzaDemo() {
        this.newClient = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.doneOrder = new ArrayList<>();
    }

    public static void main(String[] args) {

        PizzaDemo pizzaDemo = new PizzaDemo();

        Waiter w = new Waiter(pizzaDemo);
        Cook c = new Cook(pizzaDemo);

        new Thread(w).start();
        new Thread(c).start();

        for(int i = 0; i < 10; i++) {
            new Thread(new Client(pizzaDemo)).start();
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pizzaDemo.setClose();
    }


    public void newClAdd(Client client) {
        System.out.println("Client came");
        newClient.add(client);
        newClient.notify();
    }
    public List<Client> getNewClList() {
        return newClient;
    }

    public void takeNewOrder() {

        newClient.remove(0);
        synchronized (orders) {
            System.out.println("1 Order is taken");
            orders.add(new Order());
            orders.notify();
        }
    }

    public void receiveOrder() {

        synchronized (doneOrder) {
            System.out.println("1 Order receive to client");
            doneOrder.remove(0);

        }
    }

    public void cookOrder() {

        synchronized (doneOrder) {
            System.out.println("2 Order is cooked");
            doneOrder.add(orders.get(0));
            doneOrder.notify();
        }
        orders.remove(0);

    }

    public void waiterTask() throws InterruptedException {

        while(isWork) {
            synchronized (newClient) {
                //synchronized (doneOrder) {
                    while (newClient.isEmpty() && doneOrder.isEmpty())
                    {
                        System.out.println("1 Wait for new client");
                        newClient.wait();
                        //doneOrder.wait();
                    }

                    if (!newClient.isEmpty()) {
                        Thread.sleep(1000);
                        takeNewOrder();
                    }
                    if (!doneOrder.isEmpty()) {
                        Thread.sleep(2000);
                        receiveOrder();
                    }
               // }
            }
        }
    }

    public void cookTask() throws InterruptedException {
        while(isWork) {
            synchronized (orders) {
                while(orders.isEmpty()) {
                    System.out.println("2 wait for new order");
                    orders.wait();
                    System.out.println("2 end wait");
                }
                Thread.sleep(3000);
                cookOrder();

            }
        }
    }

    public void setClose() {
        this.isWork = false;

    }
}
