package lessons.patterns_homework.logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFileLogger implements ILogger {
    private File fileW;
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private Date dateNow = new Date();

    @Override
    public void write(Object o) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append(o).append("\t").append(simpleDateFormat.format(dateNow)).append("\n");
        System.out.println("Enter file name");

        try {
            fileW = new File("src/lessons/patterns_homework/logger/logs/" + READER.readLine());

            try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileW, true)))
            {
                out.write(new String(sb));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
