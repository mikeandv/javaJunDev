package lessons.concurrent_homework.habor;

import java.util.concurrent.Callable;

public class LoadShip implements Callable<Integer> {
    Ship ship;
    String currentDockName;

    public LoadShip(Ship ship, String dock) {
        this.ship = ship;
        this.currentDockName = dock;
    }

    @Override
    public Integer call() throws Exception {

        if(this.ship.getLoading() > 0) {
            while (this.ship.getLoading() > 0) {
                System.out.println("Идет погрузка корабля в доке " + currentDockName);
                System.out.println("Осталось " + this.ship.getLoading() + " единиц груза");
                Thread.sleep(5000);
                this.ship.setLoading(this.ship.getLoading() - 1);
            }
            return 0;
        } else {
            System.out.println(">>>>>> Погрузка окончена");
            return 0;
        }
    }
}
