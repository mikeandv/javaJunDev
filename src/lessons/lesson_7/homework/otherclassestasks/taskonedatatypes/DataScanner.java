package lessons.lesson_7.homework.otherclassestasks.taskonedatatypes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataScanner {
    private  String str;

    public DataScanner() {

    }

    public void analyseInput() {

        switch (test(str)) {

            case "Double":
                //System.out.println("Double");
                print(Double.valueOf(this.str));
                break;
            case "short":
                //System.out.println("short");
                print(Short.valueOf(this.str).shortValue());
                break;
            case "Integer":
                //System.out.println("Integer");
                print(Integer.valueOf(this.str));
                break;

                default:
                    System.out.println("String");
                    break;
        }

    }

    public void dataRead() {
        Scanner s = new Scanner(System.in);
        this.str = s.nextLine();
    }

    public String getStr() {
        return str;
    }


    private String test(String s) {

        Pattern pDouble = Pattern.compile("^\\d+\\.\\d+");
        Matcher m = pDouble.matcher(s);
        if (m.matches()
//                && (Double.parseDouble(s) <= Double.MAX_VALUE)
//                && (Double.parseDouble(s) >= Double.MIN_VALUE)
        ) {

            return "Double";
        }

        Pattern pShort = Pattern.compile("\\d+");
        m = pShort.matcher(s);
        if (m.matches() &&
                ((128 > Integer.parseInt(s)) && (Integer.parseInt(s) > 0))) {
            return "short";
        }

        Pattern pInteger = Pattern.compile("^[\\-]?\\d+");
        m = pInteger.matcher(s);
        if (m.matches()
                && ((128 <= Integer.parseInt(s)) || (Integer.parseInt(s) <= 0))
//                && (Integer.parseInt(s) <= Integer.MAX_VALUE)
//                && (Integer.parseInt(s) >= Integer.MIN_VALUE)
        ) {

            return "Integer";
        }

        return "String";
    }

    private void print(Object o) {
        System.out.println(o.getClass());
    }
}
