package lessons.lesson_15.homework;

import java.io.*;

public class TaskFile23 {

    public static void copyFilesFromDir(File dirFrom, String dirTo) {

        File[] listFile = dirFrom.listFiles();
        File newDir = new File(dirTo);
        newDir.mkdir();

        for(File f : listFile) {

            if(f.isDirectory())
                continue;

            try(
                    BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(f));
                    BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(new File(dirTo, f.getName())))
            )
            {
                byte[] byteArr = new byte[1024];
                int len;

                while((len = buffIn.read(byteArr)) > 0) {
                    buffOut.write(byteArr, 0, len);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args != null && args.length == 2) {
            copyFilesFromDir(new File(args[0]), args[1]);
//            System.out.println(args[0]);
//            System.out.println(args[1]);
        }
    }
}
