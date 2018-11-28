package lessons.lesson_16;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable { //интерфейс не имеет методов, указание имплементации служит для пометки класса
    private int launchCount;
    private Date lastLaunch;
    private String lastUser;


    public void update() {
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");
    }

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public String toString() {
        return "lessonwork{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser=" + lastUser +
                '}';
    }
}
