package lessons.thread_homework.taskone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException{

        File f = new File("files/text_for_top.txt");
        List<Thread> t = new ArrayList<>(ThreadTopWord.getParts());

        ThreadTopWord topWord = new ThreadTopWord(new ReaderFile(f).readToList());

        for(int i = 0; i < ThreadTopWord.getParts(); i++) {
            t.add(new Thread(new ConcreteThread(topWord)));
        }

        for(Thread th : t) {
            th.start();
        }

        for(Thread th : t) {
            th.join();
        }

        topWord.printTopW();
    }

}
