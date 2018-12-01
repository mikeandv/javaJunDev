package lessons.lesson_15.homework;

import lessons.lesson_11.homework.task1.StInput;
import lessons.lesson_11.homework.task2.NumIn;

import java.io.*;

public class Task2 {

    public void fileSep2(File file, int size) {

        int part = 1;

        byte[] buff = new byte[1024 * size];

        try( InputStream in = new FileInputStream(file);
             BufferedInputStream buffIn = new BufferedInputStream(in)
        ) {
            int len;

            while ( (len = buffIn.read(buff)) > 0) {
                String[] fileName = file.getName().split("\\.");
                File newFile = new File(file.getParent(), (fileName[0] + "_part" + part++ + "." + fileName[1]));

                try(OutputStream out = new FileOutputStream(newFile)){
                    out.write(buff, 0, len);
                }

            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }



    }

    public void fileGlue (File[] files, String newName) {

        for(int i = 0; i < files.length; i++) {

            byte[] buff = new byte[1024];

            try (
                    InputStream in = new FileInputStream(files[i]);
                    BufferedInputStream buffIn = new BufferedInputStream(in)

            ) {
                int len;

                while ( (len = buffIn.read(buff)) > 0) {
                    String[] fileName = files[i].getName().split("\\.");
                    File newFile = new File(files[i].getParent(), (newName + "." + fileName[1]));

                    try(OutputStream out = new FileOutputStream(newFile, true)){
                        out.write(buff, 0, len);
                    }

                }

            } catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }


    public static void main(String[] args) {

        Task2 t = new Task2();
        t.fileSep2(new File("files/" + StInput.read()), NumIn.read());

        File[] f = {new File("files/"+ StInput.read()), new File("files/"+ StInput.read()), new File("files/"+ StInput.read())};
        t.fileGlue(f, StInput.read());

    }
}
