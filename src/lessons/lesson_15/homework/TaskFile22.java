package lessons.lesson_15.homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class TaskFile22 {

    private static void filesInDir(String s) {

        File dir = new File(s);
        File[] filesArr = dir.listFiles();
        StringBuilder sb = new StringBuilder();

        try(
                OutputStream out = new FileOutputStream(new File(dir, "filesInDir.txt"))
                )
        {
            for(File f : filesArr) {

                if(f.isDirectory())
                    continue;

                BasicFileAttributes atrr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                sb.append(atrr.creationTime())
                        .append("  ")
                        .append(f.getCanonicalPath().replaceAll("/[\\w\\s]*\\W*\\.+[\\w0-9]+$", ""))
                        .append("  ")
                        .append(f.getName())
                        .append("\n");
            }
            out.write(sb.toString().getBytes());

        }catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args){

        if(args != null && args.length > 0) {
            String dir = args[0];
            filesInDir(dir);
        }
//        File f = new File("/files/test.txt");
//        System.out.println(f.getCanonicalPath());
//        System.out.println(f.getCanonicalFile());
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.getAbsoluteFile());


    }
}
