package lessons.thread_homework.pizzeria;

public class Cook implements Runnable {
    PizzaDemo pizzaDemo;

    public Cook(PizzaDemo pizzaDemo) {
        this.pizzaDemo = pizzaDemo;
    }

    @Override
    public void run() {

        while(pizzaDemo.isWork()) {
            try {
                pizzaDemo.cookerTask();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
