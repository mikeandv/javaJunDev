package lessons.lesson_6.homework.filereader;

public class TXTFileHandler extends FileWorker implements Handler{

    public TXTFileHandler(Object file) {
        super(file);
    }

    @Override
    public void writeFile() {
        System.out.println("Прочитал TXT");

    }

    @Override
    public Object readFile(Object file) {
        return null;
    }
}
