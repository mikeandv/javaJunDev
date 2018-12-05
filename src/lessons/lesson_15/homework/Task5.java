package lessons.lesson_15.homework;

import java.io.*;

public class Task5 {

    public int commaCNT(File file) {
        StringBuilder sb = new StringBuilder();
        int commaCNT = 0;

        try(
                InputStream in = new FileInputStream(file);
                InputStreamReader inreader = new InputStreamReader(in, "UTF-8")
        )

        {
            int len;
            char[] charbuff = new char[100];

            while( (len = inreader.read(charbuff)) > 0 ){
                for(char c : charbuff) {
                    if(c == ',')
                        commaCNT++;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }

        return commaCNT;
    }

    public static void main(String[] args) {
        Task5 t = new Task5();

        System.out.println(t.commaCNT(new File("files/newt.txt")));

    }
}
