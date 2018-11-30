package lessons.lesson_15.homework;

import lessons.lesson_11.homework.task1.StInput;

import java.io.*;

public class Task1 {

    public static void fileCopy(File f1, File f2) {
        int cnt = 0;

        try(InputStream inFile = new FileInputStream(f1);
            OutputStream outFile = new FileOutputStream(f2)) {

            byte[] buffer = new byte[1024];
            int len;

            while ((len = inFile.read(buffer)) > 0) {
                outFile.write(buffer, 0, len);
                cnt =+ len;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(cnt);

    }

    public static void main(String[] args) {
        fileCopy(new File("files/"+ StInput.read()), new File("files/"+ StInput.read()));
    }

}
