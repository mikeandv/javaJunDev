package lessons.lesson_15.homework;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Task4 {

    public Set<Byte> fileByteSort(File file) {
        Set<Byte> byteSet = new TreeSet();

        try(
                InputStream in = new FileInputStream(file);
                //BufferedInputStream buffIn = new BufferedInputStream(in)
        ) {



            //StringBuilder sb = new StringBuilder();
            while (in.available() > 0) {

                byteSet.add((byte) in.read());

            }

        } catch (IOException e) {
            e.getMessage();
        }
        return byteSet;
    }

    public static void fileBytePrint(Set<Byte> sb) {
        for (Byte b : sb) {
            System.out.print(b + " ");
        }
    }

    public static void main(String[] args) {

        Task4 t = new Task4();
        fileBytePrint(t.fileByteSort(new File("files/test.txt")));


    }
}
