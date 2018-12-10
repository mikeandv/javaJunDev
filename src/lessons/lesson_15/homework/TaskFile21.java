package lessons.lesson_15.homework;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFile21 {

    public static void wordRemover(File file, int from, int to ) {
        try(
                BufferedReader buff =
                        new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file)))
        ) {
            StringBuilder sb = new StringBuilder();
            String str;

            while((str = buff.readLine()) != null) {
                str = str.replaceAll("\\b[a-zA-Zа-яА-ЯЁё0-9]{2,6}\\b\\s*", "");

                sb.append(str).append("\n");
            }

            File outFileDir = new File(file.getParent(), "_new");
            if (!outFileDir.exists())
                outFileDir.mkdir();
            try(OutputStream out = new FileOutputStream(new File(outFileDir, "newfile.txt")))
            {
                byte[] buffBytes = sb.toString().getBytes();
                out.write(buffBytes, 0 , buffBytes.length);
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {

        TaskFile21.wordRemover(new File("files/test.txt"), 4, 8);
//        String s = "Ты Следующее занятие начнем с обсуждения дз точно.";

       // System.out.println(s.replaceAll("\\b[а-яА-ЯЁё]{2,6}\\b\\s*", ""));

    }
}
