package lessons.lesson_6.homework.filereader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    private Object file;
    private String fileName;

    public FileWorker(Object file, String fileName) {
        this.file = file;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }


    private boolean test(String testString, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(testString);
        return m.matches();

        //".+\\.xml$"
    }
}

