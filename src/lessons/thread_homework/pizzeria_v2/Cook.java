package lessons.thread_homework.pizzeria_v2;

public class Cook implements Runnable {
    PizzaDemo pizzaDemo;

    public Cook(PizzaDemo pizzaDemo) {
        this.pizzaDemo = pizzaDemo;
    }



    @Override
    public void run() {
        System.out.println("2 cooker on work");
        try {
//            Thread.sleep(5000);
            pizzaDemo.cookTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
