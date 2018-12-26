package lessons.thread_blockin_q_hm.top100words;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    int parts = Runtime.getRuntime().availableProcessors();

    BlockingQueue<String> strings = new ArrayBlockingQueue<>(10, true);
    BlockingQueue<Map<String, Integer>> mapBlockingQueue = new ArrayBlockingQueue<>(parts, true);
    private Map<String, Integer> finalMap = new HashMap<>();
    private final String EXITCMD = "process_end";


    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        Main m = new Main();
        for(int i = 0;i < m.parts; i++) {
            threads.add(new Thread(new Worker(m)));
        }

        for(Thread t : threads) {
            t.start();
        }

        try(BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream("files/text_for_top.txt"))))
        {
            String s;
            while((s = buff.readLine()) != null) {

                m.strings.put(s);
            }

            for(int i = 0;i < m.parts; i++) {
                m.strings.put(m.getEXITCMD());
            }

        } catch (IOException | InterruptedException e) {
            e.getMessage();
        }

        for(Thread t : threads) {
            t.join();
        }
        m.saveToAllMap();
        m.printTopW();

    }

    public String getEXITCMD() {
        return EXITCMD;
    }

    public void saveToAllMap() {

        for(Map<String, Integer> map : mapBlockingQueue) {
            for (Map.Entry entry : map.entrySet()) {
                finalMap.merge(entry.getKey().toString(), (Integer) entry.getValue(), (oldVal, newVal) -> oldVal + newVal);
            }
        }
    }
    public void printTopW() {
        finalMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(100).forEach(System.out::println);

//
    }
}
