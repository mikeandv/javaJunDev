package lessons.thread_homework.pizzeria;

import java.util.List;

public class PizzaDemo {
    private int cookRequest = 0;
    private int readyMeal = 0;
    private int newClient = 0;
    private int client = 0;
    public boolean isWork;
    public List<Order> orders;

    public PizzaDemo() {
        this.isWork = true;
    }


    public static void main(String[] args) throws InterruptedException {

        PizzaDemo pizzaDemo = new PizzaDemo();
        Waiter waiter = new Waiter(pizzaDemo);
        Cook cooker = new Cook(pizzaDemo);

        new Thread(waiter).start();
        new Thread(cooker).start();


        for (int i = 0; i < 10; i++) {
            new Thread(new Client(pizzaDemo)).start();
        }


        Thread.sleep(1000000);
        pizzaDemo.isWork = false;

    }

    public synchronized void waiterTask() throws InterruptedException{

        while (readyMeal == 0 && newClient == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (readyMeal > 0) {
            System.out.println("waiter >> Bring order to client");
            System.out.println("waiter >> Bringing...");
            Thread.sleep(500);
            readyMealMinus();

            orders.remove(orders.size()-1);
            System.out.println("waiter >> Your meal, pls");
            notify();
        } else if (newClient > 0) {
            System.out.println("waiter >> Take order from new client");
            System.out.println("waiter >> Taking order....");

            Thread.sleep(5000);
            newClientMinus();

            System.out.println("waiter >> Order take");
            orders.add(new Order());
            cookRequestPlus();
            notify();
        }
    }

    public synchronized void cookerTask() throws InterruptedException{

        while (cookRequest == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("cooker >> Take 1 request for cook");

        cookRequestMinus();

        System.out.println("cooker >> Cooking...");
        Thread.sleep(10000);
        readyMealPlus();

        System.out.println("cooker >> Meal if done");
        notify();
    }

    public synchronized void clientPlus() {
        this.client = client + 1;
    }

    public synchronized void cookRequestPlus() {
        this.cookRequest = cookRequest + 1;
        System.out.println(this.cookRequest);
    }
    public synchronized void cookRequestMinus() {
        this.cookRequest = cookRequest - 1;
    }

    public synchronized void readyMealPlus() {
        this.readyMeal = readyMeal + 1;
    }
    public synchronized void readyMealMinus() {
        this.readyMeal = readyMeal - 1;
    }

    public synchronized void newClientPlus() {
        this.newClient = newClient + 1;
        System.out.println(this.newClient);
    }
    public synchronized void newClientMinus() {
        this.newClient = newClient - 1;
    }

    public boolean isWork() {
        return isWork;
    }

    class Order {

    }
}
