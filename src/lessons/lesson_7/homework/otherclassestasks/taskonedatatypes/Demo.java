package lessons.lesson_7.homework.otherclassestasks.taskonedatatypes;

public class Demo {
    public static void main(String[] args) {

        DataScanner d = new DataScanner();

        while (true) {

            d.dataRead();
            if (d.getStr().equals("exit"))
                return;
            d.analyseInput();
        }


//        String s = "3000009.0";
//
//        Pattern p = Pattern.compile("^\\d+\\.\\d+");
//        Matcher m = p.matcher(s);
//
//        System.out.println(m.matches());
//        //System.out.println(Integer.parseInt(s));
//        //String s1 = "\\d\\.{1}\\d";

    }
}
