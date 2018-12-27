package lessons.concurrent_homework.habor;

import java.util.concurrent.Callable;

public class UpLoadShip implements Callable<Integer> {
    Ship ship;
    String currentDockName;

    public UpLoadShip(Ship ship, String dock) {
        this.ship = ship;
        this.currentDockName = dock;
    }

    @Override
    public Integer call() throws Exception {

        if (this.ship.getUpLoading() > 0) {
            while (this.ship.getUpLoading() > 0) {
                System.out.println("Идет разгрузка корабля в доке номер " + currentDockName);
                System.out.println("Осталось " + this.ship.getUpLoading() + " единиц груза");
                Thread.sleep(5000);
                this.ship.setUpLoading(this.ship.getUpLoading() - 1);
            }
            return 0;
        } else {
            System.out.println(">>>>>> Разгрузка окончена");
            return 0;
        }
    }
}
