package lessons.lesson_6.homework.filereader;

public interface Handler {
    boolean writeFile(Object j, String st);
    String[] readFile(Object file);
}
