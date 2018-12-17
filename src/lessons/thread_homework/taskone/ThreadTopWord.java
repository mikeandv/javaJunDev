package lessons.thread_homework.taskone;

import java.util.HashMap;
import java.util.Map;

public class ThreadTopWord implements Runnable {
    String threadName;
    Thread[] thread;
    Map<Integer, String> map = new HashMap<>();


    public ThreadTopWord() {
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            threadName = "Поток # " + i;
            //thread = new Thread(this, threadName);
            System.out.println("Создан " + thread);
            //thread.start();
        }
    }

    public static void main(String[] args){

        ThreadTopWord t = new ThreadTopWord();
        //t.thread.join();

    }

    @Override
    public void run() {

    }




}
