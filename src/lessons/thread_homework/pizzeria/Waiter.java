package lessons.thread_homework.pizzeria;

public class Waiter implements Runnable {
    PizzaDemo pizzaDemo;

    public Waiter(PizzaDemo pizzaDemo) {
        this.pizzaDemo = pizzaDemo;
    }

    @Override
    public void run() {

        while(pizzaDemo.isWork()) {
            try {
                pizzaDemo.waiterTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
