package lessons.concurrent_homework.habor;


import java.util.concurrent.*;

public class Dock implements Runnable {
    private BlockingQueue<Ship> serviceShip = new ArrayBlockingQueue<>(1, true);
    private Ship ship;
    private String name;
    private int idleCounter = 0;

    public Dock(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(">>>>>> Dock " + name + " start");
        while (true) {

            try {
                Ship tmp = HarborDemo.harborTake();
                if(tmp == null)
                    break; //  выход из цикла ожидания если из очереди получено пустое значение

                serviceShip.put(tmp);
                this.ship = serviceShip.take();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ExecutorService executor = Executors.newFixedThreadPool(2);

            UpLoadShip upLoadShip = new UpLoadShip(this.ship, this.name);
            LoadShip loadShip = new LoadShip(this.ship, this.name);

            FutureTask<Integer> taskForUpLoad = new FutureTask<>(upLoadShip);
            FutureTask<Integer> taskForLoad = new FutureTask<>(loadShip);

            executor.execute(taskForUpLoad);
            executor.execute(taskForLoad);

            boolean workInProgress = true;

            while (workInProgress) {
                if (taskForLoad.isDone() && taskForUpLoad.isDone()) {
                    System.out.println(">>>>>> Ship is done");
                    executor.shutdown();
                    workInProgress = false;
                    continue;
                }
            }
        }
    }
}
