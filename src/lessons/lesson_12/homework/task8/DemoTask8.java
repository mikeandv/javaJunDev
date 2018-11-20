package lessons.lesson_12.homework.task8;



import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoTask8 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("Андреев", "08.11.1981");
        map.put("Скурихин", "01.06.1990");
        map.put("Жгутова", "11.12.1980");
        map.put("Мясников", "04.07.2000");
        map.put("Солохненко", "21.08.1976");
        map.put("Дегтярев", "01.01.2008");
        map.put("Пятаков", "01.03.2000");
        map.put("Котиков", "31.02.1980");
        map.put("Шмобс", "02.02.2000");
        map.put("Жуков", "07.11.1988");


        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    "Value: " + entry.getValue());
        }

        for (String s : findInd(map)) {
            map.remove(s);
        }

        System.out.println("========================");

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    " Value: " + entry.getValue());
            }
        }

        public static ArrayList<String> findInd(Map < String, String > map) {

            Pattern p = Pattern.compile(".+\\.(06|07|08)\\..+");
            ArrayList<String> arrayList = new ArrayList<>();

            for (Map.Entry entry : map.entrySet()) {

                Matcher m = p.matcher(entry.getValue().toString());
                if (m.matches()) {
                    arrayList.add(entry.getKey().toString());
                }
            }
            return arrayList;
        }
    }


