package lessons.patterns.factory;

abstract class Handler{
    abstract void read();
    abstract void write();
}

class TxtHandler extends Handler {

    @Override
    void read() {
        System.out.println("read from txt");
    }

    @Override
    void write() {
        System.out.println("write to txt");
    }
}

class XmlHandler extends Handler {

    @Override
    void read() {
        System.out.println("read from xml");
    }

    @Override
    void write() {
        System.out.println("write to xml");
    }
}

public class Factory {

    public Handler getInstance(String st) {

        Handler handler = null;

        if(st.endsWith(".txt")) {
            handler = new TxtHandler();
        } else if(st.endsWith(".xml")) {
            handler = new XmlHandler();
        }
        return handler;
    }

    public static void main(String[] args) {

        Factory factory = new Factory();
        String fileName = "cat.xml";

        Handler handler = factory.getInstance(fileName);
        handler.read();
        handler.write();
    }
}
