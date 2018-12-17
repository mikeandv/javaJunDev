package lessons.lesson_22;


import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class SomeClass {
    private static volatile boolean run = true; //volatile - тчение и запись в переменную будет являться атомарной т.е.чтение будет всегда актуальным

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++) {
            new SomeThread().start();
        }

        Thread.sleep(3000);
        run = false;
    }

    private static class SomeThread extends Thread {

        @Override
        public void run() {
            while (run) {
                try{
                    sleep(1);
                } catch (InterruptedException e) {
                    run = false;
                    e.printStackTrace();
                }
            }
        }
    }

    //Многопоточные коллекции
//    коллекции с синхронизированным доступом
//    Vector
//    Hashtable
//    Stack
//    StringBuffer

//    однопоточные коллекции плюс декоратор
    List<String> stringList = Collections.synchronizedList(new ArrayList<>());
    Set<String> set = Collections.synchronizedSet(new HashSet<>());
    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

//    java.util.concurrent. - пакет добавлен в джававерсии 1.5
//    многопоточные коллекции
//    интерфейс ConcurrentMap - горантирует атомартность при чтнении и записи в коллекцию
//    операции чтения не требуют блокировку
//    операции записи могут происходить без блокировки

//    putIfAbsent(key, val)
//    remove(key, val)
//    replace(key, oldValue, newValue)


//    реализации
//    ConcurrentHashMap - блокировка на уровне сегментов
//    ConcurrentSkipList (Skip list алгоритм)

//    интерфейс BlockingQueue - блокирующие очереди

//    вставка
//    add(o) - выбросит исключение если данные некуда будет вставлять
//    offer(o) - чтение
//    put(o) -  если добавлять некуда то поток будет заблокирован и разбужен когда освободится место

//    удаление
//    remove() - если очередь пустая то выбросит исключение
//    poll()
//    take() - будет блокировать поток до тех пор пока не будет что уделять

//    ArrayBlockingQueue - очередь фиксированного размера
//
//    Конструкторы
//    new ArrayBlockingQueue(int capacity)
//    new ArrayBlockingQueue(int capacity, boolean fair)
//    new ArrayBlockingQueue(int capacity, boolean fair, Collection collection)

//    LinkedBlockingQueue() - размер не указыватся, но он задан как максимальное значение у Integer
//    new LinkedBlockingQueue()
//    new LinkedBlockingQueue(int copacity)
//    new LinkedBlockingQueue(Collection collection)

//    SynchronousQueue - каждая операция добавления будет ждать операции удаления, здесь всегда один элемент

}

