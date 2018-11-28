package lessons.lesson_14.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    private Map<String, Double> map;

    public Calc() {
        this.map = new HashMap<>();

    }

    public double addition (String s1, String s2) throws Exception{

        return checkedValues(s1) + checkedValues(s2);
    }

    public double substraction (String s1, String s2) throws Exception{
        return checkedValues(s1) - checkedValues(s2);
    }

    public double multiplic (String s1, String s2) throws Exception{
        return checkedValues(s1) * checkedValues(s2);
    }

    public double division (String s1, String s2) throws Exception {
        if (checkedValues(s2) == 0)
            throw new Exception("division on zero");
        return checkedValues(s1) / checkedValues(s2);
    }

    public void mapAdd(String s, Double d) {
        this.map.put(s,d);
    }

//    public Map<String, Double> getMap() {
//        return map;
//    }

    public void setValue(String s1, String s2) throws Exception{

        if (s1.matches("[a-zA-Z]+")
                && s2.matches("[a-zA-Z]+")) {
            if (!this.map.containsKey(s2)) {
                throw new Exception("not a statement");
            }
            mapAdd(s1, this.map.get(s2));
        } else {
            mapAdd(s1, Double.valueOf(s2));
        }
    }
    public Double checkedValues(String s) throws Exception{
        if (s.matches("\\-?\\d+|\\d+\\.\\d+"))
        {
            return Double.valueOf(s);

        } else if (s.matches("[a-zA-Z]+")
                && this.map.containsKey(s)) {
            return Double.valueOf(this.map.get(s));
        } else {
            throw new Exception("not a statement");
        }
    }
}
