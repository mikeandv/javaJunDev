package lessons.thread_homework.taskone;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreadTopWord {
    public static final int parts = Runtime.getRuntime().availableProcessors();
    private int partToWork = 0;

    Map<String, Integer> mapAll = new HashMap<>();
    List<List<String>> arrList = new ArrayList<>();


    public ThreadTopWord(List<String> stringList) {

        for(int i = 0; i < parts; i++) {
            List<String> t = new ArrayList<>();
            for (int j = (stringList.size()/parts) * i; j < ((i == parts - 1)?stringList.size():(stringList.size()/parts) * (i + 1)); j++) {
                t.add(stringList.get(j));
            }
            int g = 6;
            arrList.add(t);
        }

    }

    public synchronized void saveToAllMap(Map<String, Integer> m) {
        for(Map.Entry entry : m.entrySet()) {
            mapAll.merge(entry.getKey().toString(), 1, (oldVal, newVal)-> oldVal + newVal);
        }
    }

    public void printTopW() {
//        int cnt = 0;
//        for (Map.Entry entry : mapAll.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//            if(cnt == 100)
//                break;
//            else
//                cnt++;
//        }

        mapAll.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

//
    }

    public static int getParts() {
        return parts;
    }
    public synchronized int partToWork() {
        System.out.println(partToWork);
        return partToWork++;
    }
}
