package lessons.lesson_3.homework;

import java.util.Scanner;

public class TaskString1_2 {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);

        System.out.println("Введите строку");
        String strFull = st.nextLine();

        System.out.println("Введите подстроку для поиска в строке");
        String strSub = st.nextLine();

        System.out.println("Введите подстроку для замены");
        String strRepl = st.nextLine();

        System.out.println("Результат замены:");
        String strNew = strFull.replaceAll(strSub, strRepl);
        System.out.println(strNew);

        //Замена пробелов и повторяющихся символов
        StringBuffer strBuff = new StringBuffer(strNew);

        //Замена пробелов
        int k = 0;
        for (int i = 0; i < strBuff.length(); i++){
            if (!Character.isWhitespace(strBuff.charAt(i))){
                strBuff.setCharAt(k++, strBuff.charAt(i));
            }
        }
        strBuff.delete(k, strBuff.length());


        //Удаление повторов символов
        for (int i = 0; i < strBuff.length(); i++) {
            for (int j = i + 1; j < strBuff.length(); j++) {
                if (strBuff.charAt(i) == strBuff.charAt(j)) {
                    strBuff.deleteCharAt(j);
                    i -= i;
                }
            }
        }
        System.out.println(strBuff);

    }
}

