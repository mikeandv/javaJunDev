package lessons.patterns_homework.Alarm;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Alarm> alarms = new ArrayList<>();
    private boolean activeGreen = false;
    private boolean activeYellow = false;
    private boolean activeRed = false;

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }
    public void deleteListener(Alarm alarm) { alarms.remove(alarm);
    }
    public void tempUpDown(int temp) {
        notifyAlarms(temp);
    }
    private void notifyAlarms(int temp) {
        for(Alarm alarm : alarms)
            alarm.tempChanged(temp);
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.addAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if(temp >= 100 && temp < 300 && !sensor.isActiveGreen()) {
                    sensor.setActiveGreen(true);
                    System.out.println("Green");
                }
                if (temp < 100 && sensor.isActiveGreen())
                    sensor.setActiveGreen(false);
            }
        });
        sensor.addAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if(temp >= 300 && temp < 600 && !sensor.isActiveYellow()) {
                    sensor.setActiveYellow(true);
                    System.out.println("Green, Yellow");
                }
                if (temp < 300 && sensor.isActiveYellow())
                    sensor.setActiveYellow(false);
            }
        });
        sensor.addAlarm(new Alarm() {
            @Override
            public void tempChanged(int temp) {
                if(temp >= 600 && !sensor.isActiveRed()) {
                    sensor.setActiveRed(true);
                    System.out.println("Green, Yellow, Red");
                }
                if (temp < 600 && sensor.isActiveRed())
                    sensor.setActiveRed(false);
            }
        });

        int temp = 0;
        for(int i = 0; i < 1000; i++) {
            int rand = (int) (Math.random()* 100);

                temp += rand;



                sensor.tempUpDown(temp);
            }
    }


    public boolean isActiveGreen() {
        return activeGreen;
    }

    public void setActiveGreen(boolean activeGreen) {
        if(activeGreen == true) {
            this.activeGreen = true;
        } else {
            this.activeGreen = false;
        }
    }

    public boolean isActiveYellow() {
        return activeYellow;
    }

    public void setActiveYellow(boolean activeYellow) {
        if(activeYellow == true) {
            this.activeYellow = true;
            this.activeGreen = true;
        } else {
            this.activeYellow = false;
        }
    }

    public boolean isActiveRed() {
        return activeRed;
    }

    public void setActiveRed(boolean activeRed) {
        if(activeRed == true) {
            this.activeGreen = true;
            this.activeYellow = true;
            this.activeRed = true;
        } else {
            this.activeRed = false;
        }
    }
}
