package lessons.thread_homework.pizzeria_v2;

public class Client implements Runnable{
  PizzaDemo pizzaDemo;

  public Client(PizzaDemo pizzaDemo) {
      this.pizzaDemo = pizzaDemo;
  }

    @Override
    public void run() {

        synchronized(pizzaDemo.getNewClList()) {
            pizzaDemo.newClAdd(this);
        }

    }
}
