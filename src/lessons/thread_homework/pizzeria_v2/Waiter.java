package lessons.thread_homework.pizzeria_v2;

public class Waiter implements Runnable{
    PizzaDemo pizzaDemo;

    public Waiter(PizzaDemo pizzaDemo) {
        this.pizzaDemo = pizzaDemo;
    }


    @Override
    public void run() {

        System.out.println("1 waiter on work");
        try {
//            Thread.sleep(5000);
            pizzaDemo.waiterTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
