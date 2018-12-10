package lessons.lesson_15.homework;

import lessons.chat.ConsoleHelper;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFile24 {
    private static final String INT = "\\d+";
    private static final String DOUBLE = "\\d+\\.\\d+";

    private static void updateRow(File f, String id, String productName, String price, String quantity) {

        if(dataCheck(id, INT)) {

        } else

    }
    private static void deleteRow(File f, String id){

    }
    private static void insertRow(File f, String productName, String price, String quantity) {

    }

    private static void operationSelect(String[] arr) throws Exception {

        File file = new File(ConsoleHelper.readString());

        switch (arr[0]) {
            case "-u":
                if (arr.length < 5 || arr.length > 5)
                    throw new Exception("Неизветные агрументы");
                updateRow(file, arr[1], arr[2], arr[3], arr[4]);
                break;
            case "-d":
                if (arr.length > 2)
                    throw new Exception("Неизветные агрументы");
                deleteRow(file, arr[1]);
            case "-c":
                if (arr.length < 4 || arr.length > 4)
                    throw new Exception("Неизветные агрументы");
                insertRow(file, arr[1], arr[2], arr[3]);
            default:
                System.out.println("Неизветные агрументы");
        }
    }
    private static boolean dataCheck(String s, String reg) {
        Pattern pattern;

        pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        if(args != null && args.length > 1) {

            try {
                operationSelect(args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
