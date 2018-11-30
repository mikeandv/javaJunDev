package lessons.lesson_15.homework;

import lessons.lesson_11.homework.task1.StInput;
import lessons.lesson_11.homework.task2.NumIn;

import java.io.*;

public class Task2 {

    public void fileSeparate(File file, long partSize) {

        try(RandomAccessFile inFile = new RandomAccessFile(file.getPath(), "r");
            RandomAccessFile outFile = new RandomAccessFile(new File("files/" + file.getName().replaceAll("\\.txt", "")+ "_part1.txt").getPath(), "rw");
            RandomAccessFile outFile2 = new RandomAccessFile(new File("files/" + file.getName().replaceAll("\\.txt", "")+ "_part2.txt").getPath(), "rw")
        )
        {
            StringBuilder sb = new StringBuilder();

            //inFile.seek(partSize);
            int b = inFile.read();
            long cnt = 0;

            while(cnt < partSize) {
                sb.append((char) b);
                b = inFile.read();
                cnt++;
            }

            byte[] bytes = sb.toString().getBytes();
            outFile.write(bytes);
            //+++++++++++++++++++

            StringBuilder sb2 = new StringBuilder();
            inFile.seek(partSize);

            b = inFile.read();

            while(b != -1) {
                sb2.append((char) b);
                b = inFile.read();
            }

            byte[] bytes2 = sb2.toString().getBytes();
            outFile2.write(bytes2);




//            byte[] buffer = new byte[1024];
//            int len;
//
//            while ((len = inFile.read(buffer)) > 0) {
//                outFile.write(buffer, 0, len);
//
//            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Task2 t = new Task2();
        t.fileSeparate(new File("files/"+ StInput.read()), (long) NumIn.read());
    }
}
