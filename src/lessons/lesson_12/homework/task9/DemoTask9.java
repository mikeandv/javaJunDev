package lessons.lesson_12.homework.task9;

import lessons.lesson_11.homework.task2.NumIn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DemoTask9 {
    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();
        map.put("Андреев", 30000);
        map.put("Скурихин", 95000);
        map.put("Жгутова", 20000);
        map.put("Мясников", 15000);
        map.put("Солохненко", 105000);
        map.put("Дегтярев", 15000);
        map.put("Пятаков", 70000);
        map.put("Котиков", 71000);
        map.put("Шмобс", 15000);
        map.put("Жуков", 95000);

        int salaryCut = NumIn.read();

        for(Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue() <= salaryCut) {
                it.remove();
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    " Value: " + entry.getValue());
        }
    }
}

//for(Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
//        Map.Entry<String, String> entry = it.next();
//        if(entry.getKey().equals("test")) {
//        it.remove();
//        }
//        }
