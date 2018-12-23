package lessons.thread_homework.pizzeria;

public class Client implements Runnable {
    PizzaDemo pizzaDemo;

    public Client(PizzaDemo pizzaDemo) {
        this.pizzaDemo = pizzaDemo;
    }

    @Override
    public void run() {

        pizzaDemo.newClientPlus();
        pizzaDemo.clientPlus();

        synchronized (pizzaDemo.orders) {
            pizzaDemo.orders.notify();
        }


    }
}
