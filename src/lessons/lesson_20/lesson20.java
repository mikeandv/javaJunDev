package lessons.lesson_20;

public class lesson20 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread());
//
//        Thread thread = new Thread();
//        thread.start();
//
//        Thread thread1 = new MyThread();
//        thread1.start();
//
//        Thread thread2 = new Thread(new OtherThread());
//        thread2.start();
//
////        Thread.currentThread() - получение текущего потока
////        thread.setName(); - задать имя потока
////        thread.getName() - получить имя потока
/////////////////////////////////////
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("In progress " + Thread.currentThread().isAlive());
//                System.out.println("In progress " + Thread.currentThread().getState());
//            }
//        });
//
//        System.out.println("Before " + thread3.isAlive());
//        System.out.println("Before " + thread3.getState());
//        thread3.start();
//        ожидаем пока поток запущен
//        thread3.join();
//
//        System.out.println("After " + thread3.isAlive());
//        System.out.println("After " + thread3.getState());
/////////////////////////////////////
//        Программа будет работать пока не заверщатся все потоки. Это касается ОСНОВНЫХ потоков
//        Потоки отмеченные как demon будут остановлены сразу после остановки последнего потоки
/////////////////////////////////////
//        Thread thread4 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        });
//
//        thread4.start();
///////////////////////////////////
//        Thread thread5 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        });
//        thread5.setDaemon(true);
//        thread5.start();
///////////////////////////////////
//      Остановка потоков:
//      1. Если в методе run выполнены все инструкции, поток выходит из метода и завершает свою работу
//      2. Если было выброшено исключение поток прекратит свою работу
//      3. Это был demon поток и последний основной поток завершил работу
//      4. Остановка JVM
///////////////////////////////////
//      Мехаинзм прерываний
///////////////////////////////////
        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()) {   //проверка прерывания потока
                    try {

                        System.out.println("thread6");
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        //Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        });
        thread6.start();
        System.out.println(thread6.isInterrupted());
        Thread.sleep(2000);
        thread6.interrupt();
///////////////////////////////////


    }
}
