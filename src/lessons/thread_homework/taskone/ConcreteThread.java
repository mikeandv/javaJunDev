package lessons.thread_homework.taskone;

import java.util.HashMap;
import java.util.Map;

public class ConcreteThread implements Runnable{
//    List<String> words;
    ThreadTopWord threadTopWord;

    public ConcreteThread(ThreadTopWord threadTopWord) {
        this.threadTopWord = threadTopWord;
    }

    @Override
    public void run() {

        System.out.println("поток запущен");
        Map<String, Integer> tmpMap = new HashMap<>();

        for(String s : threadTopWord.arrList.get(threadTopWord.partToWork())) {
            tmpMap.merge(s, 1, (oldVal, newVal)-> oldVal + newVal);
        }

        threadTopWord.saveToAllMap(tmpMap);
    }

}
