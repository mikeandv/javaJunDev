package lessons.lesson_15.homework;

import java.io.*;

public class Tast3 {

    public void fileEncrypt(File file, String pass) {

        byte[] buff = new byte[1024];
        byte[] passB = pass.getBytes();

        try(
                InputStream in = new FileInputStream(file);
                BufferedInputStream buffIn = new BufferedInputStream(in)
        ) {
            int len;

            while((len = buffIn.read(buff)) > 0) {

                for (int i = 0; i < buff.length ; i++) {
                    buff[i] = (byte) (buff[i] ^ passB[i % passB.length]);
                }


                String[] fileName = file.getName().split("\\.");
                File newFile = new File(file.getParent(), (fileName[0] + "_encr" + "." + fileName[1]));

                try (OutputStream out = new FileOutputStream(newFile, true)) {
                    out.write(buff, 0, len);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void fileDecrypt(File file, String pass) {

        byte[] buff = new byte[1024];
        byte[] passB = pass.getBytes();

        try(
                InputStream in = new FileInputStream(file);
                BufferedInputStream buffIn = new BufferedInputStream(in)
        ) {
            int len;

            while((len = buffIn.read(buff)) > 0) {

                for (int i = 0; i < buff.length ; i++) {
                    buff[i] = (byte) (buff[i] ^ passB[i % passB.length]);
                }


                String[] fileName = file.getName().split("\\.");
                File newFile = new File(file.getParent(), (fileName[0] + "_decr" + "." + fileName[1]));

                try (OutputStream out = new FileOutputStream(newFile, true)) {
                    out.write(buff, 0, len);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Tast3 t = new Tast3();

//        File f = new File("files/test.txt");
//        t.fileEncrypt(f, "Шифр");
 File fd = new File("files/test_encr.txt");
        t.fileDecrypt(fd,"Шифр");


    }
}
