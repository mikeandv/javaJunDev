package lessons.thread_homework.taskone;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ReaderFile {
    private File file;

    public ReaderFile (File f) {
        this.file = f;
    }

    public List<String> readToList() {
        List<String> lines = new ArrayList<>();
        List<String> words = new LinkedList<>();

        try(BufferedReader buff =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(file))))
        {
            String s;
            while((s = buff.readLine()) != null) {
                lines.add(s);
            }

            for(String line : lines) {
                String[] wordSp = line.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split("\\s");

                for(String st : wordSp) {
                    if(st.length() > 0)
                        words.add(st);
                }
            }

        } catch (IOException e) {
            e.getMessage();
        }
        return words;
    }
}
