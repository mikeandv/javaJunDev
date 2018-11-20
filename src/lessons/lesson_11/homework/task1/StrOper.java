package lessons.lesson_11.homework.task1;

import java.util.ArrayList;
import java.util.List;

public class StrOper {
    private List<String> stringList;

    public StrOper() {
        this.stringList = new ArrayList<>(5);
    }

    public void loadSt() {

        while (this.stringList.size() != 5) {
            System.out.println("Введите строку: ");
            this.stringList.add(StInput.read());
        }

    }
    public List<String> findShortSt() {

        List<String> tmp = new ArrayList<>();
        String shortSt = this.stringList.get(0);

        for (String s : this.stringList) {

            if (s.length() <= shortSt.length()) {
                shortSt = s;
            }
        }

        for (String s : this.stringList) {
            if (s.length() == shortSt.length()) {
                tmp.add(s);
            }
        }

        return tmp;
     }

     private void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
     }

     public void waitComand() {
         System.out.println("====================");
         System.out.print("Введите код операции");

         String cmd;

         do {
             cmd = StInput.read();
             if (cmd.equals("/short string")) {
                 print(this.findShortSt());
                 System.out.print("Введите код операции");
             } else {
                 System.out.println("Нет такой операции! Для выхода введите \"exit\"");
             }
         }
         while (!cmd.equals("exit"));

     }

}
