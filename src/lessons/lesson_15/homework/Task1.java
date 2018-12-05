package lessons.lesson_15.homework;

import lessons.lesson_11.homework.task1.StInput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static int fileCopy(File f1, File f2) {
        int cnt = 0;
        List<Byte> l = new ArrayList<Byte>();

        try(InputStream inFile = new FileInputStream(f1);
            OutputStream outFile = new FileOutputStream(f2)) {

            StringBuilder sb = new StringBuilder();


            while (inFile.available() > 0) {

                l.add((byte) inFile.read());
                cnt++;
            }

            byte[] bytes = new byte[l.size()];
            int i = 0;

            for(byte b : l) {
                bytes[i] = b;
                i++;
            }

            outFile.write(bytes);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return cnt;

    }

    public static void main(String[] args) {
        System.out.println(fileCopy(new File("files/"+ StInput.read()), new File("files/"+ StInput.read())));
    }

}
