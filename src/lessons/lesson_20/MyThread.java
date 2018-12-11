package lessons.lesson_20;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThead " + Thread.currentThread().getName());
    }
}
class OtherThread implements Runnable {

    @Override
    public void run() {
        System.out.println("OtherThread " + Thread.currentThread().getName());

    }
}
