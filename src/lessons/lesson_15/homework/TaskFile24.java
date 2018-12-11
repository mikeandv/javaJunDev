package lessons.lesson_15.homework;

import lessons.chat.ConsoleHelper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFile24 {

    private final String INT = "\\d+";
    private final String DOUBLE = "\\d+\\.\\d+";
    private boolean isDone = false;

    private void updateRow(File f, String id, String productName, String price, String quantity) {

        if(dataCheck(id, INT)) {
            try(BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(f))))
            {
                StringBuilder sb = new StringBuilder();
                String str;
                String[] strArr;

                while((str = buff.readLine()) != null) {

                    strArr = str.split(" ");

                        if (Integer.parseInt(strArr[0]) == Integer.parseInt(id)
                                && (dataCheck(price, DOUBLE) || dataCheck(price, INT))
                                && dataCheck(quantity, INT)) {
                            sb.append(id)
                                    .append(" ")
                                    .append(productName)
                                    .append(" ")
                                    .append(price)
                                    .append(" ")
                                    .append(quantity)
                                    .append("\n");
                            isDone = true;
                        } else {
                            //System.out.println("Некорректное значение в строке1");
                            sb.append(str);
                        }
                }
                try(OutputStream out = new FileOutputStream(f, false)) {
                    byte[] bytes = sb.toString().getBytes();
                    out.write(bytes, 0, bytes.length);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Некорректное значение id");
        }
        System.out.println("Операция " + (isDone? "выполнена" : "не выполнена"));

    }
    private void deleteRow(File f, String id){

        if(dataCheck(id, INT)) {
            try(BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(f))))
            {
                StringBuilder sb = new StringBuilder();
                String str;
                String[] strArr;

                while((str = buff.readLine()) != null) {

                    strArr = str.split(" ");

                    if (Integer.parseInt(strArr[0]) == Integer.parseInt(id)) {
                        isDone = true;
                    } else {
                        sb.append(str).append("\n");
                    }
                }
                try(OutputStream out = new FileOutputStream(f, false)) {
                    byte[] bytes = sb.toString().getBytes();
                    out.write(bytes, 0, bytes.length);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Некорректное значение id");
        }
        System.out.println("Операция " + (isDone? "выполнена" : "не выполнена"));
    }
    private void insertRow(File f, String productName, String price, String quantity) {

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
            StringBuilder sb = new StringBuilder();
            String str;
            String[] strArr;
            int maxInt = 0;

            while ((str = buff.readLine()) != null) {
                strArr = str.split(" ");

                if (Integer.parseInt(strArr[0]) > maxInt) {
                    maxInt = Integer.parseInt(strArr[0]);
                } else {
                    continue;
                }
            }

            if ((dataCheck(price, DOUBLE) || dataCheck(price, INT))
                    && dataCheck(quantity, INT)) {
                sb.append(++maxInt)
                        .append(" ")
                        .append(productName)
                        .append(" ")
                        .append(price)
                        .append(" ")
                        .append(quantity)
                        .append("\n");
                isDone = true;

                try (OutputStream out = new FileOutputStream(f, true)) {
                    byte[] bytes = sb.toString().getBytes();
                    out.write(bytes, 0, bytes.length);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Операция " + (isDone? "выполнена" : "не выполнена"));
    }

    private static void fileWorker() {}

    private void operationSelect(String[] arr) throws Exception {


        File file = new File("files/" + ConsoleHelper.readString());

        switch (arr[0]) {
            case "-u":
                if (arr.length < 5 || arr.length > 5)
                    throw new Exception("Некорректные агрументы");
                //if(arr[0].length() < 8 || arr[2])
                updateRow(file, arr[1], arr[2], arr[3], arr[4]);
                break;
            case "-d":
                if (arr.length > 2)
                    throw new Exception("Некорректные агрументы");
                deleteRow(file, arr[1]);
                break;
            case "-c":
                if (arr.length < 4 || arr.length > 4)
                    throw new Exception("Некорректные агрументы");
                insertRow(file, arr[1], arr[2], arr[3]);
                break;
            default:
                System.out.println("Неизветные агрументы");
        }
    }
    private boolean dataCheck(String s, String reg) {

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        if(args != null && args.length > 1) {
            TaskFile24 t = new TaskFile24();

            try {
                t.operationSelect(args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Отсутствует агрументы при запуске");
        }
    }
}
