package lessons.patterns_homework.logger;

import java.io.*;

public class FileLogger implements ILogger {
    private File fileW;
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void write(Object o) {

        StringBuilder sb = new StringBuilder();
        sb.append(o).append("\n");
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
