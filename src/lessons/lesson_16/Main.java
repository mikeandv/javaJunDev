package lessons.lesson_16;

import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        //File file = new File("stat.bin");
        File file = new File("stat2.bin");

        //LaunchStat stat;
        LaunchStatExternalizable stat;

        if(!file.exists()) {
           // stat = new LaunchStat();
            stat = new LaunchStatExternalizable();
        } else {
            try(ObjectInputStream objIn =
                    new ObjectInputStream(
                            new FileInputStream(file)))
            {
                //stat = (LaunchStat) objIn.readObject();
                stat = (LaunchStatExternalizable) objIn.readObject();

            }
        }

        if (stat.isFirstLaunch()) {
            System.out.println("Первый запуск");
        } else {
            System.out.println(stat);
        }

        stat.update();

        //сохранение

        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file)))
        {
            objOut.writeObject(stat);
        }
    }

}
