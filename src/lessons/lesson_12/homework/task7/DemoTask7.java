package lessons.lesson_12.homework.task7;

import lessons.lesson_11.homework.task1.StInput;

import java.util.HashMap;
import java.util.Map;

public class DemoTask7 {
    public static void main(String[] args) {
        Map<String, String> map  = new HashMap<>();
        map.put("Андреев", "Михаил");
        map.put("Скурихин", "Антон");
        map.put("Жгутова", "Татьяна");
        map.put("Мясников", "Виктор");
        map.put("Солохненко", "Илья");
        map.put("Дегтярев", "Олег");
        map.put("Пятаков", "Вадим");
        map.put("Котиков", "Михаил");
        map.put("Пятаков", "Олег");
        map.put("Жуков", "Антон");

        String s = StInput.read();
        int i = 0;

        for (Map.Entry entry : map.entrySet()) {
            if(entry.getValue().equals(s)) {
                i++;
            }
        }
        System.out.println("Количество вхождени " + "\"" + s + "\"" + " равно " + i);
    }
}
