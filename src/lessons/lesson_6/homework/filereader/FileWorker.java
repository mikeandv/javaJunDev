package lessons.lesson_6.homework.filereader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWorker {
    private Object file;

    public FileWorker(Object file) {
        this.file = file;
    }

    public String getFileName(){

        String fileName = "configfile.xml";
        //Реализация получения имени файла
        return fileName;
    }

    private boolean test(String testString){
        Pattern p = Pattern.compile(".+\\.xml$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}

