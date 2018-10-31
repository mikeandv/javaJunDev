package lessons.lesson_5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lessonwork {
    //
    //Регулярные выражения
    //
    public static void main(String[] args) {

        String st = "Строка b1 для поииска и замены СИМВОЛОВ";
        String pattern = "иск";

        System.out.println();
        pattern = "^Стр";   // ^ Символ начала строки
                            // $ Символ конца строки
        System.out.println(st.replaceAll(pattern, "*!*"));

        pattern = "[иск]"; // Замена каждого из меречисленнных символов
        System.out.println(st.replaceAll(pattern, "*"));

        pattern = "[^иск]"; //Поиск всех символов кроме указанных
        System.out.println(st.replaceAll(pattern, "*"));

        pattern = "\\d"; //Поиск цифровых символов
        System.out.println(st.replaceAll(pattern, "*"));

        pattern = "\\D"; //Поиск любый нецифровых символовцифровых символов
        System.out.println(st.replaceAll(pattern, "*"));

        // w - буквенно цифровой символ, аналог _
        // W - не W
        // s - замена пробелов (переносы, пробелы, табуляции)
        // S - заменяет все символы не пробельные
        // [а-яё] - буквы от а до я (маленькие)
        // [А-ЯЁ] - буквы от А до Я (заглавные)
        // [А-Я0-9] - буквы от А до Я и цифры (заглавные)
        // [А-Я][0-9] - Сначало буквы от А до Я (заглавные)б а за ней цифры 0-9

        //Классы для регулярных вырожений
        // Pattern - класс шаблона
        // Mather - содержит методы для работы с шаблоном

        //st = "Str";
        Pattern pattern1 = Pattern.compile(".{6,}"); // от 6 повторений любого символа
        // . любой символ
        //  {5, 7} количество повторений от 5 до 7. повторений символа подряд
        Matcher matcher = pattern1.matcher(st);
        System.out.println(matcher.find()); // Ищет соответствие шаблона pattern1 в заданной строке st (LIKE)
        // ?= Соответствие
        // * Повторение 0 и более раз
        pattern1 = Pattern.compile("(?=.*\\d) (?=.*[a-z]) ()");
        System.out.println(matcher.matches()); // Поиск по полному соответствию


        st = "Строка b1 для поииска и замены СИМВОЛОВ";
        pattern = "(ии|b1)"; //Символ ИЛИ выбирает и заменяет и те и те значения
        System.out.println(st.replaceAll(pattern, "*"));





    }


}
