package lessons.lesson_6.homework.filereader;

public class XMLFileHandler extends FileWorker implements Handler{

    public XMLFileHandler(Object file) {
        super(file);
    }

    @Override
    public void writeFile() {
        System.out.println("Прочитал XML");

    }

    @Override
    public Object readFile(Object file) {
        return null;
    }
}
