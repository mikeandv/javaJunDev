package lessons.thread_blockin_q_hm.top100words;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    BlockingQueue<String> strings;
    BlockingQueue<Map<String, Integer>> mapBlockingQueue;
    private final String EXIT;
    private Map<String, Integer> tmpMap;


    public Worker(Main m) {
        this.strings = m.strings;
        this.mapBlockingQueue = m.mapBlockingQueue;
        this.EXIT = m.getEXITCMD();
        this.tmpMap = new HashMap<>();
    }

    @Override
    public void run() {

        while(true) {


            String line = null;

            try {
                line = strings.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(line.equals(EXIT)) {
                try {
                    mapBlockingQueue.put(tmpMap);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

            String[] wordSp = line.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split("\\s");


            for(String s : wordSp) {
                if(s.equals(""))
                    continue;
                tmpMap.merge(s, 1, (oldVal, newVal)-> oldVal + newVal);
            }

        }
    }
}

