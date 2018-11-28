package lessons.lesson_12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {

        //Map
        // 1. Хранение данных в паке ключ-значение
        // 2. Ключи не дублируются
        // 3. Хранение зависит от реализации
        // 4. Могут хранить любые типы данных
        // (использование null в чачестве ключа зависит от реализации)

        //Основные методы
//        boolean containsKey(Object key)         возвращает true если находит ключ в Map
//        boolean containsValue(Object setValue)     возвращает true если находит значение Map
//        void putAll(Map<?extends K, ?extends V> m)
//
//        основыне методы
//        get(T key)
//        put(T key, T val)

//
//        Реализация Map
//        HashMap           Хранение на основе хэшкода ключа (используется чаще всего)
//        TreeMap           Сортировка по ключам
//        EnumMap           В качествое ключей используются перечисления
//        LinkedHashMap     Гарантируют что элементы будут хранится в порядке добаления
//        WeakMap
//        IdentityHashMap   Сравнение ключей не с помощью equals, а с помощью равенства (==)

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Elem 1");
        hashMap.put(2, "Elem 2");

//        Перебор элементов Map
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    " Value: " + entry.getValue());
        }

        Map<Integer, String> linnkedHashMap = new LinkedHashMap<>();
        linnkedHashMap.put(1, "link1");
        linnkedHashMap.put(2, "link2");
        linnkedHashMap.put(null, "link null");
        linnkedHashMap.put(2, "link3");

        for (Map.Entry entry : linnkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    " Value: " + entry.getValue());
        }

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "link1");
        treeMap.put(2, "link2");
        treeMap.put(0, "link null");    // при передачи в качестве ключа null будет исключение
        treeMap.put(2, "link3");

        for (Map.Entry entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() +
                    " Value: " + entry.getValue());

        }
        treeMap.keySet(); // возвращает коллекцию всех ключей
        treeMap.values(); // возвращает список всех значений
    }
}
